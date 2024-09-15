package grupo04.truetestu.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Carreras")

public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idCarrera;

    @Column(name= "puntaje_aproximado", nullable = false)
    private int puntajeAproximado;

    @Column(name= "descripcion_carrera", nullable = false, columnDefinition = "TEXT")
    private String descripcionCarrera;
}
