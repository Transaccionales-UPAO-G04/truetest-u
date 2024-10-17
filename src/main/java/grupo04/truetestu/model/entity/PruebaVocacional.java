package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "pruebas_vocacionales")
public class PruebaVocacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPruebaVocacional;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @OneToMany(mappedBy = "pruebaVocacional", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Pregunta> preguntas; // Relación con Pregunta
}
