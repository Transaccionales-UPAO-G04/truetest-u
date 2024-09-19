package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class ResultadoPruebaDTO {
    private int puntaje;
    private String recomendacion;
    private int idPruebaVocacional; // Si necesitas referenciar a la prueba vocacional.
}