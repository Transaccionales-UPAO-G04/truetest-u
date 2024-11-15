//NO MOVER NADA PERO SOLUCIONAR PROBLEMAS
package grupo04.truetestu.api;

import grupo04.truetestu.dto.CompraCreateUpdateDTO;
import grupo04.truetestu.dto.CompraDTO;
import grupo04.truetestu.dto.CompraReportDTO;
import grupo04.truetestu.service.CompraService;
import grupo04.truetestu.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ESTUDIANTES')")
public class CompraController {

    private final CompraService compraService;


    // Endpoint para crear una compra (creación de orden de pago en PayPal)
    @PostMapping
    public ResponseEntity<CompraDTO> createCompra(@RequestBody CompraCreateUpdateDTO compraDTO) {
        CompraDTO savedCompra = compraService.createCompra(compraDTO);
        return new ResponseEntity<>(savedCompra, HttpStatus.CREATED);
    }

    // Endpoint para obtener el detalle de una compra específica (una orden en PayPal)
    //@GetMapping("/user/{userId}")
    //public ResponseEntity<List<CompraDTO>> getCompraHistory(@PathVariable Integer userId) {
    @GetMapping("/user")
    public ResponseEntity<List<CompraDTO>> getCompraHistory() {
        List<CompraDTO> compraHistory = compraService.getCompraHistoryByUsuarioId();
        return ResponseEntity.ok(compraHistory);
    }

}
