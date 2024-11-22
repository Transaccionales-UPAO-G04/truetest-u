package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlan;

    @Column(name = "nombre_plan", nullable = false, length = 100)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(nullable = false)
    private double precio;

    @Column(columnDefinition = "TEXT")
    private String descripcionPlan;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @JsonIgnore
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiante> estudiantes; // La relación uno a muchos con Estudiantes

    @JsonIgnore
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pago> pagos;

}
