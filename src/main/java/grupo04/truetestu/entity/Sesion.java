package grupo04.truetestu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion")
    private int idSesion;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "duracion", nullable = false)
    private LocalTime duracion; // Modificado a LocalTime para reflejar el tipo "time"

    @Column(name = "participantes", nullable = false)
    private int participantes;

    @Column(name = "link", nullable = false)
    private String link;

    // Relación con Estudiante (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idEstudiante", foreignKey = @ForeignKey(name = "FK_sesion_estudiante"))
    private Estudiante estudiante;

    // Relación con Mentor (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "id_mentor", referencedColumnName = "idMentor", foreignKey = @ForeignKey(name = "FK_sesion_mentor"))
    private Mentor mentor;

}
