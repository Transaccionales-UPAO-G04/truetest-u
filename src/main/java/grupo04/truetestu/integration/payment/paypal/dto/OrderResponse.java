package grupo04.truetestu.integration.payment.paypal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class OrderResponse {
    private String id;
    private String status;

    @JsonProperty("payment_source")
    private PurchaseSource pagoSource;

    private List<Link> links;
}