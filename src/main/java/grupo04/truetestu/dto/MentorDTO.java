package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MentorDTO extends UsuarioDTO{
    private int idMentor;

    @NotBlank(message = "Tiene que ingresar experiencia")
    private String experiencia;

    @NotBlank(message = "Tiene que ingresar especialidad")
    private String especialidad;

    @NotBlank(message = "Tiene que ingresar link para los recursos gratis")
    private String linkRecurso;

    @NotBlank(message = "Tiene que ingresar link para los recursos premium")
    private String linkRecursoPremium;

    private TipoUsuario tipoUsuario = TipoUsuario.MENTOR;
}
