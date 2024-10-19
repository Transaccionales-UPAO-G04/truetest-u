package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class UsuarioDTO {

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El formato del email no es válido")
    private String email;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String contraseña;

    @NotNull(message = "El tipo de usuario no puede ser nulo")
    private TipoUsuario tipoUsuario;
}
