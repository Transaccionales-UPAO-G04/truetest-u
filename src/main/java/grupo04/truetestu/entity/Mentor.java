package grupo04.truetestu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "experiencia", nullable = false, columnDefinition = "TEXT")
    private String experiencia;

    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "nro_asesorias", nullable = false)
    private int nroAsesorias;

}
