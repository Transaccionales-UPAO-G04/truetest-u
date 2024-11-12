package grupo04.truetestu.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PreguntaDTO {
    private int idPregunta;

    @NotBlank(message = "La pregunta es obligatoria")
    private String pregunta;

    @Min(value = 0, message = "El monto debe ser al menos 0")
    @NotBlank(message = "Se necesita puntos")
    private int punto;
}
