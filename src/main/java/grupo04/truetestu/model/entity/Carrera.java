package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "carrera")

public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCarrera;

    @Column(name= "nombre_carrera", nullable = false, length = 150)
    private String nombreCarrera;

    @Column(name= "descripcion_carrera", nullable = false, columnDefinition = "TEXT")
    private String descripcionCarrera;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Especialidad> especialidades;

}
