package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.PagoCaptureResponse;
import grupo04.truetestu.dto.PagoOrderResponse;
import grupo04.truetestu.dto.PurchaseDTO;
import grupo04.truetestu.integration.payment.paypal.dto.OrderCaptureResponse;
import grupo04.truetestu.integration.payment.paypal.dto.OrderResponse;
import grupo04.truetestu.integration.payment.paypal.service.PayPalService;
import grupo04.truetestu.service.CheckoutService;
import grupo04.truetestu.service.PurchaseService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final PayPalService payPalService;  // Interacción con PayPal para crear/capturar pagos
    private final PurchaseService purchaseService; // Repositorio para guardar el estado de los pagos

    @Override
    public PagoOrderResponse createPago(Integer purchaseId, String returnUrl, String cancelUrl) {
        OrderResponse orderResponse = payPalService.createOrder(purchaseId, returnUrl, cancelUrl);

        // Buscar el enlace de aprobación para redirigir al usuario
        String paypalUrl = orderResponse
                .getLinks()
                .stream()
                .filter(link -> link.getRel().equals("approve"))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getHref();

        return new PagoOrderResponse(paypalUrl);
    }

    @Override
    public PagoCaptureResponse capturePago(String orderId) throws MessagingException{
        OrderCaptureResponse orderCaptureResponse = payPalService.captureOrder(orderId);
        boolean completed = orderCaptureResponse.getStatus().equals("COMPLETED");

        PagoCaptureResponse paypalCaptureResponse = new PagoCaptureResponse();
        paypalCaptureResponse.setCompleted(completed);

        if (completed) {
            String purchaseIdStr = orderCaptureResponse.getPurchaseUnits().get(0).getReferenceId();
            PurchaseDTO purchaseDTO = purchaseService.confirmPurchase(Integer.parseInt(purchaseIdStr));
            paypalCaptureResponse.setPurchaseId(purchaseDTO.getId());

        }
        return paypalCaptureResponse;
    }

}
