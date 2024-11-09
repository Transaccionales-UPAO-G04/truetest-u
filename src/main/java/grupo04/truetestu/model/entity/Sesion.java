package grupo04.truetestu.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSesion;

    @Column(name = "hora_sesion", nullable = false)
    private LocalTime tiempo;

    @Column(name = "fecha_sesion", nullable = false)
    private LocalDate fecha;

    @Column(name = "link_sesion_privada", nullable = false)
    private String linkSesionPrivada;

    @OneToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "mentor_id", referencedColumnName = "idMentor",
            foreignKey = @ForeignKey(name = "FK_sesion_mentor"))
    private Mentor mentor;



}
