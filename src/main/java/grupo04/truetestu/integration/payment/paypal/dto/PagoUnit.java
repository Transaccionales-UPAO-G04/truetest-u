package grupo04.truetestu.integration.payment.paypal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PagoUnit {
    @JsonProperty("reference_id")
    private String referenceId;
    private Amount amount;
}
