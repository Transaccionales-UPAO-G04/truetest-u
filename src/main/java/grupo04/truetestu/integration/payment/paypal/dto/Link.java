package grupo04.truetestu.integration.payment.paypal.dto;
import lombok.Data;


@Data
public class Link {
    private String href;
    private String rel;
    private String method;
}