package grupo04.truetestu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class MentorCreateUpdateDTO {

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(max= 255, message ="El nombre es muy largo")
    private String nombre;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El formato del email no es válido")
    private String email;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    private String contraseña;

}
