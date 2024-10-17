package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class RespuestaDTO {
    private Long idRespuesta;
    private String respuestaTexto;
    private int puntuacion;
    private Long idPregunta; // Relación con Pregunta
}
