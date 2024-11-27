//NO MOVER NADA PERO SOLUCIONAR PROBLEMAS
package grupo04.truetestu.api;

import grupo04.truetestu.dto.PurchaseReportDTO;
import grupo04.truetestu.dto.PurchaseCreateUpdateDTO;
import grupo04.truetestu.dto.PurchaseDTO;
import grupo04.truetestu.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ESTUDIANTES')")
public class PurchaseController {

    private final PurchaseService purchaseService;


    // Endpoint para crear una purchase (creación de orden de pago en PayPal)
    @PostMapping
    public ResponseEntity<PurchaseDTO> createPurchase(@RequestBody PurchaseCreateUpdateDTO purchaseDTO) {
        PurchaseDTO savedPurchase = purchaseService.createPurchase(purchaseDTO);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    // Endpoint para obtener el detalle de una purchase específica (una orden en PayPal)
    //@GetMapping("/user/{userId}")
    //public ResponseEntity<List<PurchaseDTO>> getPpurchaseHistory(@PathVariable Integer userId) {
    @GetMapping("/user")
    public ResponseEntity<List<PurchaseDTO>> getPurchaseHistory() {
        List<PurchaseDTO> purchaseHistory = purchaseService.getPurchaseHistoryByUserId();
        return ResponseEntity.ok(purchaseHistory);
    }

}
