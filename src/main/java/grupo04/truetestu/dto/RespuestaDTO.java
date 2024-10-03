package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class RespuestaDTO {
    private int id; // Agrega este campo para el ID de la respuesta
    private String texto;
    private boolean esCorrecta;
}


