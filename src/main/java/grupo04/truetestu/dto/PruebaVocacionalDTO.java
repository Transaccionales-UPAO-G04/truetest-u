package grupo04.truetestu.dto;

import lombok.Data;
import java.util.List;

@Data
public class PruebaVocacionalDTO {
    private Long idPruebaVocacional;
    private String nombre;
    private String descripcion;
    private List<PreguntaDTO> preguntas;
}




