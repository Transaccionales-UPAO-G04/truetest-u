package grupo04.truetestu.model.entity;
import grupo04.truetestu.model.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "mentor")
public class Mentor extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMentor;

    @Column(name = "experiencia", nullable = false, columnDefinition = "TEXT")
    private String experiencia;

    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;

    @Column(name = "link_recurso", nullable = false)
    private String linkRecurso;

    @Column(name = "link_recurso_premium", nullable = false)
    private String linkRecursoPremium;

    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_tipo", nullable = false)
    private TipoUsuario tipoUsuario = TipoUsuario.MENTOR;

    // Relación "Un mentor puede tener muchas reseñas"
    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reseña> reseñas;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Horario> horarios;

}
