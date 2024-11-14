package grupo04.truetestu.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PagoDTO {

    private Integer idPago;

    @NotNull(message = "El monto es obligatorio")
    @Min(value = 0, message = "El monto debe ser al menos 0")
    @Digits(integer = 10, fraction = 2, message = "El monto debe ser un número válido con hasta 10 dígitos y 2 decimales")
    private Double monto;

    @NotBlank(message = "El método de pago es obligatorio")
    private String metodoPago;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fechaPago;  // Usando LocalDateTime en lugar de Date

    private String estadoPago;  // Estado del pago, considerar usar un enum

    @NotBlank(message = "El nombre del estudiante es obligatorio")
    private String estudianteNombre;  // Información del estudiante
}
