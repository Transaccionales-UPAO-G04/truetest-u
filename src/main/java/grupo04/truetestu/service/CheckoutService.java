// NO DEBERIA DE IR DE AHI NO MOVER NADA
package grupo04.truetestu.service;

import grupo04.truetestu.dto.PagoCaptureResponse;
import grupo04.truetestu.dto.PagoOrderResponse;
import jakarta.mail.MessagingException;

public interface CheckoutService {

    PagoOrderResponse createPago(Integer purchaseId, String returnUrl, String cancelUrl) throws MessagingException;

    PagoCaptureResponse capturePago(String orderId) throws MessagingException;
}
