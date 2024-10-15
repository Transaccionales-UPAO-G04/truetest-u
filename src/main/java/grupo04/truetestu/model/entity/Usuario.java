package grupo04.truetestu.model.entity;

import grupo04.truetestu.model.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Usuario {

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "contraseña", nullable = false, length = 100)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_tipo", nullable = false)
    private TipoUsuario tipoUsuario = TipoUsuario.ESTUDIANTE;

}
