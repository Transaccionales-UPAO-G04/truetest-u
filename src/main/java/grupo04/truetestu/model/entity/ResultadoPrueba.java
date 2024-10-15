package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resultado_prueba")
public class ResultadoPrueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResultadoPrueba;

    @Column(name = "puntaje", nullable = false)
    private int puntaje;

    @Column(name = "recomendacion", nullable = false, length = 150)
    private String recomendacion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_prueba_vocacional", nullable = false)
    private PruebaVocacional pruebaVocacional;
}
