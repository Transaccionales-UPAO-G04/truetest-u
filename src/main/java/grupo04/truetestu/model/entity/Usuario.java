package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "Usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "foto_perfil") // Opcional: Nombre de la columna en la BD
    private String fotoPerfil;

    private String password;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Mentor mentor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name ="role_id", referencedColumnName = "id")
    private Roles role;
}
