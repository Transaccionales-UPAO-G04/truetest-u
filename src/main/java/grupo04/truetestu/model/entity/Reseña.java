package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reseña")
public class Reseña {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReseña;

    @Column(name = "texto", nullable = false, columnDefinition = "TEXT")
    private String texto;

    @Column(name = "calificacion", nullable = false)
    private int calificacion;

    // Relación con Mentor (Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "id_mentor", referencedColumnName = "idMentor",
            foreignKey = @ForeignKey(name = "FK_reseña_mentor"))
    private Mentor mentor;

    // Relación con Estudiante (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_reseña_estudiante"))
    private Estudiante estudiante;

}


