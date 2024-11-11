package grupo04.truetestu.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReseñaDTO {
    private int idReseña;

    @NotBlank(message = "La reseña es obligatoria")
    private String texto;

    @NotBlank(message = "La calificacion es obligatoria")
    private int calificacion;


    public void setEstudianteDTO(EstudianteDTO estudianteDTO) {
    }
}
