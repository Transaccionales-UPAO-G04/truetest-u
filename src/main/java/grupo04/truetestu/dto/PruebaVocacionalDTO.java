package grupo04.truetestu.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class PruebaVocacionalDTO {
    private int idPruebaVocacional;
    private int nroPrueba;
    private LocalDate fecha;
    private String nombre;
    private String email;
    private int idEstudiante;
    private List<ResultadoPruebaDTO> pruebas;
}


