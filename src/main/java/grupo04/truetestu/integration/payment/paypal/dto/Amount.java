package grupo04.truetestu.integration.payment.paypal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class Amount {
    @JsonProperty("currency_code")
    private String currencyCode;
    private String value;
}
