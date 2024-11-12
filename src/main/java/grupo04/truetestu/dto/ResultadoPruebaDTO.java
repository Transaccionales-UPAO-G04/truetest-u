package grupo04.truetestu.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
public class ResultadoPruebaDTO {

    private Long idResultadoPrueba;

    @Positive(message = "El puntaje debe ser un número positivo")
    private int puntaje;

    @NotBlank(message = "La recomendación es obligatoria")
    private String recomendacion;

    @NotNull(message = "El ID de la prueba vocacional es obligatorio")
    @Positive(message = "El ID de la prueba vocacional debe ser un número positivo")
    private Long idPruebaVocacional;
}
