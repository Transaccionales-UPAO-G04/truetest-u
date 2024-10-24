package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Pago;
import grupo04.truetestu.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Endpoint para obtener todos los pagos
    @GetMapping
    public List<Pago> obtenerTodosLosPagos() {
        return pagoService.obtenerTodosLosPagos(); // Retorna todos los pagos
    }

    // Endpoint para realizar un pago
    @PostMapping
    public Pago realizarPago(@RequestBody Pago pago) {
        return pagoService.realizarPago(pago); // Realiza el pago
    }

    // Endpoint para obtener un pago por ID
    @GetMapping("/{idPago}")
    public Pago obtenerPagoPorId(@PathVariable int idPago) {
        return pagoService.obtenerPagoPorId(idPago); // Retorna el pago por ID
    }

    // Endpoint para obtener pagos por ID de estudiante
    @GetMapping("/estudiante/{idEstudiante}")
    public List<Pago> obtenerPagosPorIdEstudiante(@PathVariable int idEstudiante) {
        return pagoService.obtenerPagosPorIdEstudiante(idEstudiante); // Retorna pagos por ID de estudiante
    }

    // Endpoint para obtener pagos por ID de plan
    @GetMapping("/plan/{idPlan}")
    public List<Pago> obtenerPagosPorIdPlan(@PathVariable int idPlan) {
        return pagoService.obtenerPagosPorIdPlan(idPlan); // Retorna pagos por ID de plan
    }
}
