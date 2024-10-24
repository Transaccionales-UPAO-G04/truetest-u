package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resultado_prueba")
public class ResultadoPrueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultadoPrueba;

    private int puntaje;
    private String recomendacion;

    @ManyToOne
    @JoinColumn(name = "id_prueba_vocacional", nullable = false)
    private PruebaVocacional pruebaVocacional; // Relación con PruebaVocacional
}
