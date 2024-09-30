package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class RespuestaDTO {
    private Integer id;
    private String texto;
    private boolean esCorrecta;  // Indica si la respuesta es correcta o no
}

