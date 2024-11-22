package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.AuthResponseDTO;
import grupo04.truetestu.dto.LoginDTO;
import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.dto.UserRegistrationDTO;
import grupo04.truetestu.model.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UsuarioMapper {
    private final ModelMapper modelMapper;

    public Usuario toUserEntity(UserRegistrationDTO userRegistrationDTO) {
        return modelMapper.map(userRegistrationDTO, Usuario.class);
    }



    public UserProfileDTO toUserProfileDTO(Usuario usuario) {
        UserProfileDTO userProfileDTO = modelMapper.map(usuario, UserProfileDTO.class);

        if(usuario.getMentor()!=null) {
            userProfileDTO.setId(usuario.getMentor().getIdMentor());
            userProfileDTO.setNombre(usuario.getMentor().getNombre());
            userProfileDTO.setEspecialidad(usuario.getMentor().getEspecialidad());
            userProfileDTO.setExperiencia(usuario.getMentor().getExperiencia());
            userProfileDTO.setLinkRecurso(usuario.getMentor().getLinkRecurso());
            userProfileDTO.setLinkRecursoPremium(usuario.getMentor().getLinkRecursoPremium());
        }

        if(usuario.getEstudiante()!=null) {
            userProfileDTO.setId(usuario.getEstudiante().getIdEstudiante());
            userProfileDTO.setNombre(usuario.getEstudiante().getNombre());
            userProfileDTO.setFotoPerfil(usuario.getEstudiante().getFotoPerfil());
        }

        return userProfileDTO;
    }

    //Convertir de LoginDTO a User (cuando procesas el login)
    public Usuario toUserEntity(LoginDTO loginDTO) {
        return modelMapper.map(loginDTO, Usuario.class);
    }
    //Convertir de User a AuthResponseDTO para la respuesta de autenticación
    public AuthResponseDTO toAuthResponseDTO(Usuario usuario, String token){
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(token);

        authResponseDTO.setId(usuario.getId());

        // Obtener el nombre y apellido
        String nombre = (usuario.getEstudiante() != null) ? usuario.getEstudiante().getNombre()
                : (usuario.getMentor() != null) ? usuario.getMentor().getNombre()
                : "Admin";
        authResponseDTO.setNombre(nombre);
        authResponseDTO.setRole(usuario.getRole().getName().name());

        return authResponseDTO;
    }



}
