package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class ResultadoPruebaDTO {
    private Long idResultadoPrueba;
    private int puntaje;
    private String recomendacion;
    private Long idPruebaVocacional; // Referencia a la prueba vocacional
}

