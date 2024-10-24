package grupo04.truetestu.model.entity;

import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.model.enums.EstadoEstudiante;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre_estudiante", nullable = false, length = 150)
    private String nombreEstudiante;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email es inválido")
    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Column(name = "contraseña", nullable = false, length = 100)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_plan", nullable = false)
    private EstadoPlan estadoPlan = EstadoPlan.NOPREMIUM;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cuenta", nullable = false)
    private EstadoCuenta estadoCuenta = EstadoCuenta.HABILITADO;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_estudiante", nullable = false)
    private EstadoEstudiante estadoEstudiante = EstadoEstudiante.ACTIVO; // Valor predeterminado

    @OneToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "idPlan",
            foreignKey = @ForeignKey(name = "FK_estudiante_plan"))
    private Plan plan;
}


