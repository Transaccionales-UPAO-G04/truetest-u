package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "preguntas")
public class Pregunta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPregunta; // Cambiado de int a Long para un rango más amplio

        @Column(name = "texto_pregunta", nullable = false, length = 250)
        private String textoPregunta; // Cambiado el nombre del campo para evitar confusión

        @Column(name = "puntos", nullable = false)
        private int puntos; // Cambiado el nombre a plural para ser más descriptivo

        @JsonIgnore
        @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
        @JoinColumn(name = "id_respuesta", referencedColumnName = "idRespuesta",
                foreignKey = @ForeignKey(name = "FK_pregunta_respuesta"))
        private Respuesta respuesta;

        @JsonIgnore
        @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
        @JoinColumn(name = "id_prueba_vocacional", referencedColumnName = "idPruebaVocacional",
                foreignKey = @ForeignKey(name = "FK_pregunta_prueba_vocacional"))
        private PruebaVocacional pruebaVocacional;

        @JsonIgnore
        @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
        @JoinColumn(name = "id_carrera", referencedColumnName = "idCarrera",
                foreignKey = @ForeignKey(name = "FK_pregunta_carrera"))
        private Carrera carrera;
}