package grupo04.truetestu.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Singular;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class EstudianteDTO {
    private int idEstudiante;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no debe pasar los 50 caracteres")
    private String nombreEstudiante;
    @NotBlank(message = "El correo es obligatorio")
    @Size(max = 50, message = "El correo no debe pasar los 50 caracteres")
    private String email;
}
