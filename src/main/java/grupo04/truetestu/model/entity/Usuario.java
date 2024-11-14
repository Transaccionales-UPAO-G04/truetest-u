package grupo04.truetestu.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import grupo04.truetestu.model.enums.TipoUsuario;  // Asegúrate de importar tu enum

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String contraseña;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Estudiante estudiante;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Mentor mentor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Roles role;

    // Nuevo campo para el tipo de usuario
    @Enumerated(EnumType.STRING)  // Esto almacena como texto en la base de datos
    private TipoUsuario tipoUsuario;
}
