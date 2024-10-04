package grupo04.truetestu.dto;

import lombok.Data;

import java.util.List;

@Data
public class PreguntaDTO {
    private Integer id;
    private String texto; // Este puede corresponder al contenido de la Pregunta
    private String tipo;
    private List<RespuestaDTO> respuestas;// Lista de respuestas asociadas
    private List<PreguntaDTO> preguntas;

}



