//revisado y ok
package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.EstadoPago;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PurchaseDTO {
    private Integer id;
    private LocalDateTime createdAt;
    private EstadoPago estadoPago;
    private String estudianteName;
    private List<PurchaseItemDTO> items;
}
