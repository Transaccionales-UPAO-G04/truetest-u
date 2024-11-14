package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.UsuarioProfileDTO;
import grupo04.truetestu.dto.UsuarioRegistrationDTO;
import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.exception.RoleNotFoundException;
import grupo04.truetestu.mapper.UsuarioMapper;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.model.entity.Roles;
import grupo04.truetestu.model.entity.Usuario;
import grupo04.truetestu.model.enums.TipoUsuario;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.repository.RolesRepository;
import grupo04.truetestu.repository.UsuarioRepository;
import grupo04.truetestu.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MentorRepository mentorRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;
    private final EstudianteRepository estudianteRepository;

    @Transactional
    @Override
    public UsuarioProfileDTO registrarMentor(UsuarioRegistrationDTO registrationDTO) {
        return registrarMentorWithRole(registrationDTO, TipoUsuario.MENTOR);
    }
    @Transactional
    @Override
    public UsuarioProfileDTO registrarEstudiante(UsuarioRegistrationDTO registrationDTO) {
        return registrarMentorWithRole(registrationDTO, TipoUsuario.ESTUDIANTE);
    }

    @Transactional
    @Override
    public UsuarioProfileDTO updateUsuario(int id, UsuarioProfileDTO userProfileDTO) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        //Verificar si ya existe un cliente o autor con el mismo nombre y apellido (excepto el usuario actual)
        boolean existsAsEstudiante = estudianteRepository.existsByNombreAndUsuarioIdNot(userProfileDTO.getNombre(),userProfileDTO.getId()) ;
        boolean  existsAsMentor = mentorRepository.existsByNombreAndUsuarioIdNot(userProfileDTO.getNombre(),userProfileDTO.getId()) ;

        System.out.println("Mentor exists: " + existsAsMentor);

        if(existsAsEstudiante || existsAsMentor){
            throw new IllegalArgumentException("Ya existe un usuario con el mismo nombre e ID");
        }



        if(usuario.getEstudiante()!=null){

            usuario.getEstudiante().setNombre(userProfileDTO.getNombre());

        }

        if(usuario.getMentor()!=null){
            usuario.getMentor().setNombre(userProfileDTO.getNombre());
            usuario.getMentor().setLinkRecursoPremium(userProfileDTO.getLinkRecursoPremium());
            usuario.getMentor().setEspecialidad(userProfileDTO.getEspecialidad());
            usuario.getMentor().setExperiencia(userProfileDTO.getExperiencia());
            usuario.getMentor().setLinkRecurso(userProfileDTO.getLinkRecurso());
        }

        Usuario updatedUsuario = usuarioRepository.save(usuario);

        return usuarioMapper.toUsuarioProfileDTO(updatedUsuario);
    }
    @Transactional
    @Override
    public UsuarioProfileDTO getUsuarioProfileById(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado"));
        return usuarioMapper.toUsuarioProfileDTO(usuario);
    }

    private UsuarioProfileDTO registrarMentorWithRole(UsuarioRegistrationDTO registrationDTO, TipoUsuario roleEnum) {

            //verificar si el email esta registrado
            boolean existsByEmail = usuarioRepository.existsByEmail(registrationDTO.getEmail());
            boolean existsAsMentor = mentorRepository.existsByNombre(registrationDTO.getNombre());
            boolean existasAsEstudiante = estudianteRepository.existsByNombre(registrationDTO.getNombre());

            if (existsByEmail) {
                throw new IllegalArgumentException("El email ya existe");
            }

            if (existsAsMentor || existasAsEstudiante ) {
                throw new IllegalArgumentException("El usuario ya existe");
            }

            Roles role = rolesRepository.findByName(roleEnum)
                    .orElseThrow(() -> new RoleNotFoundException("ERROR: Rol no encontrado"));

            registrationDTO.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

            Usuario usuario = usuarioMapper.toUsuarioEntity(registrationDTO);
            usuario.setRole(role);

            if (roleEnum == TipoUsuario.ESTUDIANTE) {
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(registrationDTO.getNombre());
                estudiante.setUsuario(usuario);
                usuario.setEstudiante(estudiante);
            } else if (roleEnum == TipoUsuario.MENTOR) {
                Mentor mentor = new Mentor();
                mentor.setNombre(registrationDTO.getNombre());
                mentor.setExperiencia(registrationDTO.getExperiencia());
                mentor.setEspecialidad(registrationDTO.getEspecialidad());
                mentor.setLinkRecurso(registrationDTO.getLinkRecurso());
                mentor.setLinkRecursoPremium(registrationDTO.getLinkRecursoPremium());
                mentor.setUsuario(usuario);
                usuario.setMentor(mentor);
            }

            Usuario savedUsuario = usuarioRepository.save(usuario);

        return usuarioMapper.toUsuarioProfileDTO(savedUsuario);
    }
}
