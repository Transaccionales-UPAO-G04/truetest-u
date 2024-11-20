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
            @RequestParam @NotNull Integer pagoId,  // Añadí validación para evitar que falte el ID
            @RequestParam @NotNull String returnUrl,  // Validación para el URL de retorno
            @RequestParam @NotNull String cancelUrl,  // Validación para el URL de cancelación
            @RequestParam(required = false, defaultValue = "paypal") String paymentProvider
    ) {
        try {
            // Llamada al servicio para crear la orden de pago
            PagoOrderResponse response = checkoutService.createPago(pagoId, returnUrl, cancelUrl);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (MessagingException e) {
            // Manejamos MessagingException específicamente
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e) {
            // Manejo de excepciones
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Captura la orden de pago
     */
    @PostMapping("/capture")
    public ResponseEntity<PagoCaptureResponse> capturePagosOrder(
            @RequestParam @NotNull String orderId,  // Validación para el orderId
            @RequestParam(required = false, defaultValue = "paypal") String paymentProvider
    ) {
        try {
            // Llamada al servicio para capturar la orden de pago
            PagoCaptureResponse response = checkoutService.capturePago(orderId);

            if (response.isCompleted()) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Manejo de excepciones
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
