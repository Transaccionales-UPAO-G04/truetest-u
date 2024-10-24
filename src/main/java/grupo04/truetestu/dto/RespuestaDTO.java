package grupo04.truetestu.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Data
public class RespuestaDTO {

    private Long idRespuesta;

    @NotBlank(message = "El texto de la respuesta es obligatorio")
    private String respuestaTexto;

    @Positive(message = "La puntuación debe ser un número positivo")
    private int puntuacion;

    @NotNull(message = "El ID de la pregunta es obligatorio")
    @Positive(message = "El ID de la pregunta debe ser un número positivo")
    private Long idPregunta;
}
