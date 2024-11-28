package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.AuthResponseDTO;
import grupo04.truetestu.dto.LoginDTO;
import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.dto.UserRegistrationDTO;
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
import grupo04.truetestu.repository.UsuarioRespository;
import grupo04.truetestu.security.TokenProvider;
import grupo04.truetestu.security.UserPrincipal;
import grupo04.truetestu.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @Transactional
    @Override
    public UserProfileDTO registrarMentor(UserRegistrationDTO registrationDTO) {
        return registrarMentorWithRole(registrationDTO, TipoUsuario.MENTOR);
    }
    @Transactional
    @Override
    public UserProfileDTO registrarEstudiante(UserRegistrationDTO registrationDTO) {
        return registrarMentorWithRole(registrationDTO, TipoUsuario.ESTUDIANTE);
    }

    ////// SOLO PARA REGISTRAR UN ADMIN, LUEGO QUITARLO
    @Transactional
    @Override
    public UserProfileDTO registrarAdmin(UserRegistrationDTO registrationDTO) {
        return registrarMentorWithRole(registrationDTO, TipoUsuario.ADMIN);
    }

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        //autenticar usuariocon AutheticationManager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );

        //una vez autenticado, el objeto contiene la inforcamacion del usuario atenticado
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Usuario usuario = userPrincipal.getUsuario();

        String token = tokenProvider.createAccessToken(authentication);

        AuthResponseDTO responseDTO = usuarioMapper.toAuthResponseDTO(usuario,token);

        return responseDTO;
    }

    @Transactional
    @Override
    public UserProfileDTO updateUsuariosProfile(int id, UserProfileDTO userProfileDTO) {

        Usuario usuario = usuarioRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        //Verificar si ya existe un cliente o autor con el mismo nombre y apellido (excepto el usuario actual)
        boolean existsAsEstudiante = estudianteRepository.existsByNombreAndUsuarioIdNot(userProfileDTO.getNombre(),id) ;
        boolean  existsAsMentor = mentorRepository.existsByNombreAndUsuarioIdNot(userProfileDTO.getNombre(),id) ;

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

        Usuario updatedUsuario = usuarioRespository.save(usuario);

        return usuarioMapper.toUserProfileDTO(updatedUsuario);
    }

    @Transactional
    @Override
    public UserProfileDTO getUsuarioProfileById(int id) {
        Usuario usuario = usuarioRespository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado"));
        return usuarioMapper.toUserProfileDTO(usuario);
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

    @Transactional
    @Override
    public void actualizarFotoPerfil(int id, String fotoPerfil) {
        Usuario usuario = usuarioRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        usuario.setFotoPerfil(fotoPerfil); // Actualizar directamente en Usuario

        usuarioRespository.save(usuario); // Guardar los cambios
    }



}
