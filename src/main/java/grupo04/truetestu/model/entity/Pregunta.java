package grupo04.truetestu.model.entity;

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
        @JoinColumn(name = "id_prueba_vocacional", nullable = false)
        private PruebaVocacional pruebaVocacional; // Asociación con PruebaVocacional
}





