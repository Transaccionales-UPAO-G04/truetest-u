package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "mentor")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mentor")
    private int idMentor;

    @Column(name = "nombre_mentor", nullable = false)
    private String nombreMentor;

    @Column(name = "experiencia", nullable = false)
    private int experiencia; // Asegúrate de que sea un tipo int

    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Column(name = "nro_asesorias", nullable = false)
    private int nroAsesorias;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resena> reseñas;

    // Remover cualquier relación innecesaria que pueda estar causando problemas
    // Si no necesitas una relación dentro de Mentor, remueve esta sección
}










