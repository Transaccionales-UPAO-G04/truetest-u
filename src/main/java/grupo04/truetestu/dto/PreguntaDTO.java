package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class PreguntaDTO {
    private Long idPregunta;
    private String textoPregunta;
    private int puntos;
    private Long idPruebaVocacional; // Relación con PruebaVocacional
    private Long idCarrera; // Relación con Carrera
}
