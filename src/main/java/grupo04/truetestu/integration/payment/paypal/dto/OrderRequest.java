package grupo04.truetestu.integration.payment.paypal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String intent;

    @JsonProperty("compra_units")
    private List<CompraUnit> compraUnits;

    @JsonProperty("application_context")
    private ApplicationContext applicationContext;
}