package grupo04.truetestu.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RespuestaDTO {
    private int idRespuesta;

    @NotBlank(message = "Opciones obligatorias")
    private String opciones;
}
