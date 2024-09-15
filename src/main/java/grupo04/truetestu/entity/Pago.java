package grupo04.truetestu.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @Column(name = "estado_pago", nullable = false, length = 50)
    private String estadoPago;

    // Relación Muchos a Uno con Estudiante
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_pago_estudiante"))
    private Estudiante estudiante;

    // Relación Muchos a Uno con Plan
    @ManyToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "idPlan",
            foreignKey = @ForeignKey(name = "FK_pago_plan"))
    private Plan plan;
}
