package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)  // Esto dice que no puede ser NULL en la base de datos
    private String texto;

    @Column(nullable = false)
    private boolean esCorrecta;
}

