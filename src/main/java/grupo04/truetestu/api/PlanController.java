package grupo04.truetestu.api;

import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.model.entity.Pago;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.service.impl.PlanServiceImpl;
import grupo04.truetestu.service.impl.PagoServiceImpl;
import grupo04.truetestu.service.impl.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planes")
public class PlanController {

    @Autowired
    private PlanServiceImpl planService;

    @Autowired
    private PagoServiceImpl pagoService;

    @Autowired
    private EstudianteServiceImpl estudianteService;

    // Endpoint para obtener la lista de planes
    @GetMapping
    public List<Plan> obtenerPlanes() {
        return planService.obtenerTodosLosPlanes();
    }

    // Endpoint para realizar un pago y activar el plan
    @PostMapping("/pago")
    public Pago realizarPago(@RequestBody Pago pago) {
        // Guardar el pago realizado
        Pago nuevoPago = pagoService.realizarPago(pago);

        // Verificar si el plan es premium o no
        Estudiante estudiante = pago.getEstudiante();
        if (pago.getPlan().getNombrePlan().equalsIgnoreCase("premium")) {
            estudiante.setEstadoPlan(EstadoPlan.PREMIUM);
        } else {
            estudiante.setEstadoPlan(EstadoPlan.NOPREMIUM);
        }

        estudianteService.cambiarPlan(estudiante.getIdEstudiante(), estudiante.getEstadoPlan());

        return nuevoPago;
    }
}
