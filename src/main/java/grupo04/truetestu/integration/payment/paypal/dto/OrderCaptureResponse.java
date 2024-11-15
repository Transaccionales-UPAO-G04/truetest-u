package grupo04.truetestu.integration.payment.paypal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class OrderCaptureResponse {
    private String status;

    @JsonProperty("compra_units")
    private List<CompraUnit> compraUnits;
}
