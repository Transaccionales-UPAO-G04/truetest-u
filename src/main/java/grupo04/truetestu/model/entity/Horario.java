package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "hora", nullable = false)
    private LocalTime horaSesion;

    @Column(name = "link", nullable = false)
    private String linkSesion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_mentor", referencedColumnName = "idMentor",
            foreignKey = @ForeignKey(name = "FK_horario_mentor"))
    private Mentor mentor;
}

