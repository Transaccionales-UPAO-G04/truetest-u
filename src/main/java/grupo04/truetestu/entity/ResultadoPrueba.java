package grupo04.truetestu.entity;

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

    @Column(name= "puntaje", nullable = false)
    private int puntaje;

    @Column(name= "recomendacion", nullable = false, length = 150)
    private String recomendacion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_prueba_vocacional", referencedColumnName = "idPruebaVocacional",
            foreignKey = @ForeignKey(name = "FK_resultado_prueba"))
    private PruebaVocacional pruebaVocacional;
}
