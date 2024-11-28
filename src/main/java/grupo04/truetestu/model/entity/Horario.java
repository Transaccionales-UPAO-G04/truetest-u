package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime horaSesion;

    @Column(name = "link_sesion_publica", nullable = false)
    private String linkSesionPublica;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_mentor", referencedColumnName = "idMentor",
            foreignKey = @ForeignKey(name = "FK_horario_mentor"))
    private Mentor mentor;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_horario_estudiante"))
    private Estudiante estudiante;

}

