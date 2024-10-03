package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "especialidades")  // Nombre de la tabla en la base de datos
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    // Aquí podrías agregar relaciones, como por ejemplo con otra entidad
    // @ManyToOne, @OneToMany, etc., dependiendo de tus necesidades.
}

