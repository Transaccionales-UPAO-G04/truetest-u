package grupo04.truetestu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResultadoPruebaDTO {
    private int idResultado;

    @NotBlank(message = "Tiene que haber puntaje")
    private int puntaje;

    @NotBlank(message = "Tiene que haber recomendacion")
    private String recomendacion;
}
