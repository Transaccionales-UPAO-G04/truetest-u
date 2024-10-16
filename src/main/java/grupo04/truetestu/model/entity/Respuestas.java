package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "respuestas")

public class Respuestas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(name = "opciones", nullable = false, length = 150)
    private String opciones;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_especialidad"))
    private Especialidad especialidad;


    @ManyToOne
    @JoinColumn(name = "pregunta_id", referencedColumnName = "idPregunta",
            foreignKey = @ForeignKey(name = "FK_pregunta"))
    private Pregunta pregunta;

}
