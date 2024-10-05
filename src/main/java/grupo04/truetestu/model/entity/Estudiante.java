package grupo04.truetestu.model.entity;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoEstudiante;
import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.model.entity.Pago;
import grupo04.truetestu.model.entity.PruebaVocacional;
import grupo04.truetestu.model.entity.Recurso;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private int idEstudiante;

    @Column(name = "nombre_estudiante", nullable = false)
    private String nombreEstudiante;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    // Permitir valor nulo para estadoPlan
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_plan", nullable = true)  // Ahora permite valores nulos
    private EstadoPlan estadoPlan;

    // Permitir valor nulo para estadoCuenta
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_cuenta", nullable = true)  // Ahora permite valores nulos
    private EstadoCuenta estadoCuenta = EstadoCuenta.HABILITADO;

    // Permitir valor nulo para estadoEstudiante
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_estudiante", nullable = true)  // Ahora permite valores nulos
    private EstadoEstudiante estadoEstudiante;

    // Permitir valor nulo para la relación con Plan
    @OneToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "idPlan", nullable = true,
            foreignKey = @ForeignKey(name = "FK_estudiante_plan"))
    private Plan plan;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PruebaVocacional> pruebasVocacionales;  // Agregado para cascada

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recurso> recursos;
}



