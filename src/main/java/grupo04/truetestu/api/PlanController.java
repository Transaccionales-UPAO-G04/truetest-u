package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.model.entity.Pago;
import grupo04.truetestu.service.impl.PlanServiceImpl;
import grupo04.truetestu.service.impl.PagoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/planes")
public class PlanController {

    @Autowired
    private PlanServiceImpl planService;

    @Autowired
    private PagoServiceImpl pagoService;

    // Endpoint para obtener la lista de planes
    @GetMapping
    public List<Plan> obtenerPlanes() {
        return planService.obtenerTodosLosPlanes();
    }

    // Endpoint para buscar un plan por ID
    // Nuevo endpoint para obtener un plan por ID
    @GetMapping("/{idPlan}")
    public Plan obtenerPlanPorId(@PathVariable int idPlan) {
        return planService.obtenerPlanPorId(idPlan);  // Ya devuelve directamente un Plan
    }


    // Endpoint para realizar un pago y activar el plan
    @PostMapping("/pago")
    public Pago realizarPago(@RequestBody Pago pago) {
        return pagoService.realizarPago(pago);
    }
}
