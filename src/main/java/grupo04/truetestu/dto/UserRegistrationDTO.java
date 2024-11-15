package grupo04.truetestu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationDTO {

    @NotBlank(message = "El campo es obligtario")
    private String nombre;
    @Email(message = "El correo es obligatorio")
    @NotBlank(message = "EL CORREO ES OBLIGATORIO")
    private String email;
    @NotBlank(message = "ES NECESARIO UNA CONTRASEÑA")
    @Size(min = 3, message = "CONTRASEÑA MUY CORTA")
    private String password;




    private String experiencia;
    private String especialidad;
    private String linkRecurso;
    private String linkRecursoPremium;

}