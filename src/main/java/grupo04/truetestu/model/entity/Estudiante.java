package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_plan", nullable = false)
    private EstadoPlan estadoPlan = EstadoPlan.NOPREMIUM;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "id_plan", referencedColumnName = "idPlan",
            foreignKey = @ForeignKey(name = "FK_estudiante_plan"))
    private Plan plan;
}