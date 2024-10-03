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

    @Column(name = "experiencia", nullable = true)  // Ahora permite valores nulos
    private Integer experiencia;  // Cambiado a Integer para permitir valores nulos

    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "nro_asesorias", nullable = true)  // Ahora permite valores nulos
    private Integer nroAsesorias;  // Cambiado a Integer para permitir valores nulos
}

