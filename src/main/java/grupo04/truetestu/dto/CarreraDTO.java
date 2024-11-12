package grupo04.truetestu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarreraDTO {

    private long idCarrera;

    @NotBlank(message = "El nombre de la carrera es obligatorio")
    private String nombreCarrera;

    @NotBlank(message = "La carrera necesita una descripcion")
    private String descripcionCarrera;

}
