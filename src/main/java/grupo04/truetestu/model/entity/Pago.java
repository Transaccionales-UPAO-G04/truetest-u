package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @Column(name = "fecha_pago", nullable = false)
    private Date createdAt;


    @ManyToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "idPlan", foreignKey = @ForeignKey(name = "FK_pago_plan"))
    private Plan plan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Estudiante", referencedColumnName = "idEstudiante")
    private Estudiante estudiante;


}
