package grupo04.truetestu.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "mentor")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMentor;

    @Column(name = "nombre_mentor", nullable = false, length = 50)
    private String nombreMentor;

    @Column(name = "experiencia", nullable = false, length = 100)
    private String experiencia;

    @Column(name = "nombre_especialidad", nullable = false, length = 50)
    private String nombreEspecialidad;

    @Column(name = "nro_asesorias", nullable = false)
    private int nroAsesorias;

    // Relación OneToMany con Horario
    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    private List<Horario> horarios;

    // Métodos adicionales si es necesario
}
