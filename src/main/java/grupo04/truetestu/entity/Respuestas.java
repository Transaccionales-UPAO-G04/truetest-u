package grupo04.truetestu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "respuestas")

public class Respuestas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idOpcion;

    @Column (name = "opciones", nullable = false, length = 50)
    private String opciones;

    @ManyToOne
    @JoinColumn (name = "pregunta_id",referencedColumnName = "pregunta"
    , foreignKey = @ForeignKey(name = "FK_pregunta_respuestas"))
    private Preguntas preguntas;

}
