package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class PurchaseItemDTO {
    private Integer id;
    private Float price;
    private String NombrePlan;     // Nombre del plan de asesoría
}
