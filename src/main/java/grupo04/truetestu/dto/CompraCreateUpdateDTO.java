package grupo04.truetestu.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CompraCreateUpdateDTO {

    // Si quieres los detalles completos del plan
    private PlanDTO plan;

    private EstudianteDTO estudiante;

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Integer estudianteId;

    @NotNull(message = "El ID del plan es obligatorio")
    private Integer idPlan;

    @NotNull(message = "El método de pago es obligatorio")
    @Size(min = 3, max = 50, message = "El método de pago debe tener entre 3 y 50 caracteres")
    private String metodoPago;

    @Size(min = 1, message = "Debe haber al menos un item de pago")
    private List<CompraItemCreateUpdateDTO> items;

    // Getter y Setter
    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }
}
