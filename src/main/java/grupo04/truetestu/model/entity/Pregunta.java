package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name= "preguntas")

public class Pregunta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idPregunta;

        @Column(name = "pregunta",nullable = false, length = 250)
        private String pregunta;

        @Column(name = "punto",nullable = false)
        private int punto;

        @JsonIgnore
        @OneToMany(mappedBy = "pregunta",cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Respuestas> respuestas;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "id_prueba_vocacional", referencedColumnName = "idPruebaVocacional",
                foreignKey = @ForeignKey(name = "FK_PruebaVocacional"))
        private PruebaVocacional pruebaVocacional;

}
