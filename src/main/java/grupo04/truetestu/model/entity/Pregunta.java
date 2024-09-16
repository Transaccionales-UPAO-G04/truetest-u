package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

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
        @OneToOne
        @JoinColumn (name = "id_respuestas",referencedColumnName = "idRespuesta"
                , foreignKey = @ForeignKey(name = "FK_pregunta_respuesta"))
        private Respuestas respuestas;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "id_prueba_vocacional", referencedColumnName = "idPruebaVocacional",
                foreignKey = @ForeignKey(name = "FK_pregunta_prueba-vocacional"))
        private PruebaVocacional pruebaVocacional;
}
