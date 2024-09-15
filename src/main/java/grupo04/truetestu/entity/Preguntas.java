package grupo04.truetestu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name= "Preguntas")

public class Preguntas {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String pregunta;

        @Column(name = "punto",nullable = false, length = 50)
        private int punto;

        @ManyToOne
        @JoinColumn(name = "PruebaVocational_id", referencedColumnName = "idPruebaVocacional"
        , foreignKey = @ForeignKey(name = "FK_purchase_customer"))
        private PruebaVocacional pruebaVocacional;

        @OneToMany(mappedBy = "preguntas", cascade = CascadeType.ALL)
        private List<Respuestas> resp;

}
