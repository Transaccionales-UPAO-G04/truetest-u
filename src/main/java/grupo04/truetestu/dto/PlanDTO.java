package grupo04.truetestu.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PlanDTO {
    private int idPlan;

    @NotBlank(message = "El nombre del plan es obligatorio")
    private String nombrePlan;

    @NotNull(message = "El monto es obligatorio")
    @Min(value = 0, message = "El precio debe ser al menos 0")
    @Digits(integer = 10, fraction = 2, message = "El precio debe ser un número válido con hasta 10 dígitos y 2 decimales")
    private double precio;

    @NotBlank(message = "La descripcion del plan es obligatorio")
    private String descripcionPlan;

    @NotBlank(message = "La fecha de inicio es obligatoria")
    private Date fechaInicio;

}