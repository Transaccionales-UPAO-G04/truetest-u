package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.dto.UserRegistrationDTO;
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
import grupo04.truetestu.repository.UsuarioRespository;
import grupo04.truetestu.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRespository usuarioRespository;
    private final MentorRepository mentorRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;
    private final EstudianteRepository estudianteRepository;


    @Override
    public UserProfileDTO registrarMentor(UserRegistrationDTO registrationDTO) {
        return registrarMentorWithRole(registrationDTO, TipoUsuario.MENTOR);
    }

    @Override
    public UserProfileDTO registrarEstudiante(UserRegistrationDTO registrationDTO) {
        return registrarMentorWithRole(registrationDTO, TipoUsuario.ESTUDIANTE);
    }

    @Override
    public UserProfileDTO updateUsuario(int id, UserProfileDTO updateDTO) {
        return null;
    }

    @Override
    public UserProfileDTO getUsuarioProfileById(int id) {
        return null;
    }

    private UserProfileDTO registrarMentorWithRole(UserRegistrationDTO registrationDTO, TipoUsuario roleEnum) {

            //verificar si el email esta registrado
            boolean existsByEmail = usuarioRespository.existsByEmail(registrationDTO.getEmail());
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

            Usuario usuario = usuarioMapper.toUserEntity(registrationDTO);
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

            Usuario savedUsuario = usuarioRespository.save(usuario);

        return usuarioMapper.toUserProfileDTO(savedUsuario);
    }
}
