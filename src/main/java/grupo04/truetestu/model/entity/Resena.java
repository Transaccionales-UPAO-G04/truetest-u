package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resena")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private int idResena;

    @Column(name = "texto", nullable = false, columnDefinition = "TEXT")
    private String texto;

    @Column(name = "calificacion", nullable = false)
    private int calificacion;

    // Relación con Mentor (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "id_mentor", referencedColumnName = "idmentor", // Cambiado a "id_mentor"
            foreignKey = @ForeignKey(name = "FK_resena_mentor"))
    private Mentor mentor;

    // Relación con Estudiante (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idestudiante",
            foreignKey = @ForeignKey(name = "FK_resena_estudiante"))
    private Estudiante estudiante;
}


