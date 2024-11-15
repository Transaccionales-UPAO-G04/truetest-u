package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.EstadoPago;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CompraDTO {
    private Integer id;
    private Integer idPlan;
    private Double total;
    private LocalDateTime createdAt;
    private String estadoPago;
    private String estudianteName;
    private List<CompraItemDTO> items;
}
