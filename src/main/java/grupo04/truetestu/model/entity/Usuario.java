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

    private String password;

    @Column(name = "foto_perfil", length = 255)
    private String fotoPerfil; // Ruta o URL de la foto de perfil seleccionada

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Mentor mentor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name ="role_id", referencedColumnName = "id")
    private Roles role;
}
