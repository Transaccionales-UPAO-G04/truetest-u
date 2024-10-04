package grupo04.truetestu.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PruebaVocacionalDTO {
    private Integer idPruebaVocacional;
    private Integer nroPrueba;
    private LocalDate fecha;
    private Integer idEstudiante;
    private String nombreEstudiante; // Este campo debe existir

    private List<PreguntaDTO> preguntas;
    private List<ResultadoPruebaDTO> pruebas;
}





