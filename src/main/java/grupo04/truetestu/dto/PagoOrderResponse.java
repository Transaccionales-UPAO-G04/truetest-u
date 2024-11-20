package grupo04.truetestu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PagoOrderResponse {
    private String paypalUrl;
}