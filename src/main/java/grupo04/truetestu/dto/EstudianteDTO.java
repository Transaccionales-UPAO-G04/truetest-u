package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.EstadoEstudiante;
import lombok.Data;

@Data
public class EstudianteDTO {
    private int idEstudiante;
    private String nombreEstudiante;
    private String email;
    private String contraseña; // Considera no exponer la contraseña en el DTO
    private EstadoEstudiante estadoEstudiante;
    private int idPlan; // Si deseas incluir el id del plan en el DTO
}
