package grupo04.truetestu.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recurso")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecurso;

    @Column(name = "link_recurso", nullable = false, length = 300)
    private String linkRecurso;

    @Column(name = "es_premium", nullable = false)
    private boolean esPremium;

    @Column(name = "es_favorito", nullable = false)
    private boolean esFavorito = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_recurso_estudiante"))
    private Estudiante estudiante;


    @ManyToOne
    @JoinColumn(name = "id_mentor", referencedColumnName = "idMentor",
            foreignKey = @ForeignKey(name = "FK_recurso_mentor"))
    private Mentor mentor;
}
