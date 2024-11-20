package grupo04.truetestu.integration.payment.paypal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompraUnit {
    @JsonProperty("reference_id")
    private String referenceId;
    private Amount amount;
}

