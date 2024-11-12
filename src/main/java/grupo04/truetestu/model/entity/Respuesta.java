package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespuesta;

    @Column(name = "texto_respuesta", nullable = false, length = 250)
    private String textoRespuesta;

    @ManyToOne // Define la relación con Pregunta
    @JoinColumn(name = "id_pregunta", nullable = false) // Cambia esto al nombre de la columna real en la base de datos
    private Pregunta pregunta; // Añade esta propiedad para la relación

    @ManyToOne // Define la relación con Especialidad
    @JoinColumn(name = "especialidad_id", nullable = false) // Cambia esto al nombre de la columna real en la base de datos
    private Especialidad especialidad; // Añade esta propiedad para la relación
}