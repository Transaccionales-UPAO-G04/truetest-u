package grupo04.truetestu.model.entity;

import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoEstudiante;
import grupo04.truetestu.model.enums.EstadoPlan;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;

    @Column(name = "nombre_estudiante", nullable = false, length = 150)
    private String nombreEstudiante;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "contraseña", nullable = false, length = 100)
    private String contraseña;

    // Permitir valor nulo para estadoPlan
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_plan", nullable = true)  // Ahora permite valores nulos
    private EstadoPlan estadoPlan;

    // Permitir valor nulo para estadoCuenta
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cuenta", nullable = true)  // Ahora permite valores nulos
    private EstadoCuenta estadoCuenta;

    // Permitir valor nulo para estadoEstudiante
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_estudiante", nullable = true)  // Ahora permite valores nulos
    private EstadoEstudiante estadoEstudiante;

    // Permitir valor nulo para la relación con Plan
    @OneToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "idPlan", nullable = true,
            foreignKey = @ForeignKey(name = "FK_estudiante_plan"))
    private Plan plan;
}


