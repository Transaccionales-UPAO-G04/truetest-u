package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "especialidades")  // Nombre de la tabla en la base de datos
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "nombre" , nullable = false)
    private String nombre;

    @Column(name= "descripcion",length = 500)
    private String descripcion;

    @Column(name= "puntaje_aproximado", nullable = false)
    private int puntajeAproximado;

    @ManyToOne
    @JoinColumn(name = "carrera_id", referencedColumnName = "idCarrera", foreignKey = @ForeignKey(name = "FK_carerra"))
    private Carrera carrera;

    @JsonIgnore
    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;
}
