package grupo04.truetestu.dto;

import lombok.Data;

import java.util.List;

@Data
public class PreguntaDTO {
    private int id;
    private String texto;
    private String tipo;
    private List<RespuestaDTO> respuestas; // Lista de respuestas asociadas
}



