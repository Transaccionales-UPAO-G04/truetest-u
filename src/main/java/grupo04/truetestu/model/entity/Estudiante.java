package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_plan", nullable = false)
    private EstadoPlan estadoPlan = EstadoPlan.NOPREMIUM;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_Cuenta", nullable = false)
    private EstadoCuenta estadoCuenta = EstadoCuenta.HABILITADO;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos;

    @OneToMany (mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PruebaVocacional> pruebasVocacionales;  // Agregado para cascada

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recurso> recursos;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sesion> sesiones;
}