package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlan;

    @Column(name = "nombre_plan", nullable = false, length = 100)
    private String nombrePlan;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "descripcion_plan", nullable = false, columnDefinition = "TEXT")
    private String descripcionPlan;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idEstudiante",
    foreignKey = @ForeignKey(name = "FK_estudiante"))
    private Estudiante estudiante;
}
