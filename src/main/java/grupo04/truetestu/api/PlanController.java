package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.model.entity.Pago;
import grupo04.truetestu.service.impl.PlanServiceImpl;
import grupo04.truetestu.service.impl.PagoServiceImpl;
import io.swagger.v3.oas.annotations.Operation; // Importa la anotación
import io.swagger.v3.oas.annotations.Parameter; // Importa la anotación
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planes")
@PreAuthorize("hasAnyRole('ESTUDIANTE')")
public class PlanController {

    @Autowired
    private PlanServiceImpl planService;

    @Autowired
    private PagoServiceImpl pagoService;

    // Endpoint para obtener la lista de planes
    @Operation(summary = "Obtener la lista de planes",
            description = "Devuelve una lista de todos los planes disponibles.")
    @GetMapping
    public List<Plan> obtenerPlanes() {
        return planService.obtenerTodosLosPlanes();
    }

    // Endpoint para realizar un pago y activar el plan
    @Operation(summary = "Realizar un pago y activar el plan",
            description = "Registra un pago para activar el plan solicitado.")
    @PostMapping("/pago")
    public Pago realizarPago(@RequestBody Pago pago) {
        return pagoService.realizarPago(pago);
    }
}
