//ESTE NO MOVER PARA NADA
package grupo04.truetestu.api;

import grupo04.truetestu.dto.PagoCaptureResponse;
import grupo04.truetestu.dto.PagoOrderResponse;
import grupo04.truetestu.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;
import jakarta.mail.MessagingException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/checkout")
@PreAuthorize("hasRole('ESTUDIANTE')") // Asegúrate de que este rol esté bien configurado en tu sistema de seguridad
public class CheckoutController {

    private final CheckoutService checkoutService;  // Asegúrate de que CheckoutService esté marcado con @Service o @Component

    /**
     * Crea una orden de pago
     */
    @PostMapping("/create")
    public ResponseEntity<PagoOrderResponse> createPagoOrder(
            @RequestParam Integer purchaseId,  // Añadí validación para evitar que falte el ID
            @RequestParam String returnUrl,  // Validación para el URL de retorno
            @RequestParam String cancelUrl,  // Validación para el URL de cancelación
            @RequestParam(required = false, defaultValue = "paypal") String paymentProvider
    ) throws MessagingException {
        PagoOrderResponse response = checkoutService.createPago(purchaseId, returnUrl, cancelUrl);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Captura la orden de pago
     */
    @PostMapping("/capture")
    public ResponseEntity<PagoCaptureResponse> capturePagosOrder(
            @RequestParam @NotNull String orderId,  // Validación para el orderId
            @RequestParam(required = false, defaultValue = "paypal") String paymentProvider
    ) throws MessagingException {
        PagoCaptureResponse response = checkoutService.capturePago(orderId);

        if (response.isCompleted()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
