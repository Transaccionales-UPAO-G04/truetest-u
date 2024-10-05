package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore; // Asegúrate de incluir esta línea si no está presente
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "pregunta")
public class Pregunta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;  // ID de la pregunta

        @Column(nullable = false)
        private String texto; // Texto de la pregunta

        @Column(nullable = false)
        private String tipo; // Tipo de la pregunta

        @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Respuesta> respuestas; // Respuestas relacionadas con la pregunta

        @ManyToOne
        @JoinColumn(name = "id_prueba_vocacional", referencedColumnName = "idPruebaVocacional",
                foreignKey = @ForeignKey(name = "FK_pregunta_prueba-vocacional"),
                nullable = false) // Asociación con PruebaVocacional
        private PruebaVocacional pruebaVocacional;

        @JsonIgnore // Ignorar en la serialización JSON
        @ManyToOne
        @JoinColumn(name = "id_carrera", referencedColumnName = "idCarrera",
                foreignKey = @ForeignKey(name = "FK_pregunta_carrera"))
        private Carrera carrera; // Asociación con Carrera
}











