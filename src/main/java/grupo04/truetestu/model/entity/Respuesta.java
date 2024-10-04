package grupo04.truetestu.model.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Asegúrate de que este campo exista y tenga un tipo Integer

    private String texto; // Asegúrate de que este campo exista y tenga un tipo String
    private boolean esCorrecta; // Asegúrate de que este campo exista y tenga un tipo boolean

    @ManyToOne
    @JoinColumn(name = "id_pregunta")
    private Pregunta pregunta;

    // Métodos getters y setters generados por Lombok (con @Data)
}





