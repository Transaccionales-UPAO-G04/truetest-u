package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class PreguntaDTO {
    private Integer id;
    private String texto;
    private String tipo;  // Por ejemplo, si es una pregunta de opción múltiple, verdadera/falsa, etc.
}

