package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.PagoCaptureResponse;
import grupo04.truetestu.dto.PagoOrderResponse;
import grupo04.truetestu.dto.CompraDTO;
import grupo04.truetestu.integration.payment.paypal.dto.OrderCaptureResponse;
import grupo04.truetestu.integration.payment.paypal.dto.OrderResponse;
import grupo04.truetestu.integration.payment.paypal.service.PayPalService;
import grupo04.truetestu.service.CheckoutService;
import grupo04.truetestu.service.CompraService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final PayPalService payPalService;  // Interacción con PayPal para crear/capturar pagos
    private final CompraService compraService; // Repositorio para guardar el estado de los pagos

    @Override
    public PagoOrderResponse createPago(Integer CompraId, String returnUrl, String cancelUrl) {
        OrderResponse orderResponse = payPalService.createOrder(CompraId, returnUrl, cancelUrl);

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
            String compraIdStr = orderCaptureResponse.getCompraUnits().get(0).getReferenceId();
            CompraDTO compraDTO = compraService.confirmCompra(Integer.parseInt(compraIdStr));
            paypalCaptureResponse.setCompraId(compraDTO.getId());

        }
        return paypalCaptureResponse;
    }

}
