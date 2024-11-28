package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.TipoUsuario;
import lombok.Data;

@Data
public class UserProfileDTO {

    private int userId;
    private String nombre;
    private String email;
    private String fotoPerfil;//foto de perfil


    private String experiencia;
    private String especialidad;
    private String linkRecurso;
    private String linkRecursoPremium;

    private int idEstudiante; //ID ESTUDIANTE
    private int idMentor; //ID MENTOR

}