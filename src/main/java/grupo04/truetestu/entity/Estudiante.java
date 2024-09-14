package grupo04.truetestu.entity;

import grupo04.truetestu.enums.EstadoEstudiante;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;

    @Column(name= "nombre_estudiante", nullable = false, length = 50)
    private String nombreEstudiante;

    @Column(name= "contraseña", nullable = false, length = 50)
    private String contraseña;

    @Column(name= "es_premium", nullable = false)
    private boolean esPremium;

    @Enumerated(EnumType.STRING)
    private EstadoEstudiante estadoEstudiante;
}
