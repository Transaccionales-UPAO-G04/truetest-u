package grupo04.truetestu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "prueba_vocacional")
public class PruebaVocacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPruebaVocacional;

    @Column(name= "nro_prueba", nullable = false)
    private int nroPrueba;

    @Column(name= "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name= "descripcion_prueba", nullable = false, columnDefinition = "TEXT")
    private String descripcionPrueba;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_prueba_estudiante"))
    private Estudiante estudiante;

    @OneToMany(mappedBy = "pruebaVocacional", cascade = CascadeType.ALL)
    private List<ResultadoPrueba> pruebas;
}
