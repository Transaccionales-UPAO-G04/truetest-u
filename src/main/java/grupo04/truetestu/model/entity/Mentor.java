package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mentor")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMentor;

    @Column(name = "nombre_mentor", nullable = false, length = 50)
    private String nombreMentor;

    @Column(name = "experiencia", nullable = false)
    private int experiencia;  // O usa Integer si quieres permitir valores nulos

    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "nro_asesorias", nullable = false)
    private int nroAsesorias;

    @Column(nullable = false)
    private String disponibilidad;

}
