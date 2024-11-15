package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class CompraItemDTO {
    private PlanDTO plan; // Para traer los detalles del plan en vez de solo el id
    private Integer id;          // ID del ítem del pago
    private Integer idPlan;      // ID del plan de asesoría
    private String NombrePlan;     // Nombre del plan de asesoría
    private Float precio;       // Precio del plan de asesoría
}
