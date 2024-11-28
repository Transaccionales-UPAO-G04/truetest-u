package grupo04.truetestu.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReseñaDTO {
    private int idReseña;

    private String nombreEstudiante;

    @NotBlank(message = "La reseña es obligatoria")
    private String texto;

    @NotBlank(message = "La calificación es obligatoria")
    @Min(value = 1, message = "La calificación mínima es 1")
    @Max(value = 5, message = "La calificación máxima es 5")
    private int calificacion;

}
