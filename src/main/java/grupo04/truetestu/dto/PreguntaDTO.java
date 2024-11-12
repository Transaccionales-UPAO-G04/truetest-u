package grupo04.truetestu.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
public class PreguntaDTO {

    @Positive(message = "El ID de la pregunta debe ser un número positivo")
    private Long idPregunta;

    @NotBlank(message = "El texto de la pregunta es obligatorio")
    @Size(min = 5, max = 255, message = "El texto de la pregunta debe tener entre 5 y 255 caracteres")
    private String textoPregunta;

    @Positive(message = "Los puntos deben ser un número positivo")
    private int puntos;

    @NotNull(message = "El ID de la prueba vocacional es obligatorio")
    @Positive(message = "El ID de la prueba vocacional debe ser un número positivo")
    private Long idPruebaVocacional;

    @NotNull(message = "El ID de la carrera es obligatorio")
    @Positive(message = "El ID de la carrera debe ser un número positivo")
    private Long idCarrera;
}
