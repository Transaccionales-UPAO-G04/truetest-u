package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "historial_pago")
public class HistorialPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @Column(name = "fecha_pago", nullable = false)
    private Date fechaPago;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_historial_pago_estudiante"))
    private Estudiante estudiante;
}
