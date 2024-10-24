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
    private int idEstudiante; // Asegúrate de que este campo existe y se inicializa correctamente
    private List<ResultadoPruebaDTO> pruebas;
}


