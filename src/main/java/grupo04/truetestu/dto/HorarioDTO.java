package grupo04.truetestu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
public class HorarioDTO {

    private int idHorario;

    @NotBlank(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotBlank(message = "La hora es obligatorio")
    private LocalTime horaSesion;

    @NotBlank(message = "Es necesario un link publico")
    private String linkSesionPublica;

    public void setEstudianteDTO(EstudianteDTO estudianteDTO) {
    }
}
