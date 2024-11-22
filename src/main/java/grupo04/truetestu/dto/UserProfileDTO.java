package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.TipoUsuario;
import lombok.Data;

@Data
public class UserProfileDTO {

    private int id;
    private String nombre;
    private String email;
    private TipoUsuario tipoUsuario;
    private String fotoPerfil;//foto de perfil


    private String experiencia;
    private String especialidad;
    private String linkRecurso;
    private String linkRecursoPremium;

}