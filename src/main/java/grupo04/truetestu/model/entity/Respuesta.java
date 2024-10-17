package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespuesta;

    @Column(name = "texto_respuesta", nullable = false, length = 250)
    private String textoRespuesta;

    @Column(name = "correcta", nullable = false)
    private boolean correcta; // Indica si la respuesta es correcta o no
}
