package grupo04.truetestu.model.entity;

import grupo04.truetestu.model.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name= "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name= "name", nullable = false, unique = true)
    private TipoUsuario name;


}
