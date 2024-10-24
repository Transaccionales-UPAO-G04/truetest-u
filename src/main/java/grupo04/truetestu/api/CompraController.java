package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Compra;
import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.service.CompraService;
import grupo04.truetestu.service.PlanService;
import grupo04.truetestu.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;
    private final EstudianteService estudianteService;
    private final PlanService planService;

    @PostMapping("/registrar")
    public Compra registrarCompra(@RequestParam int idEstudiante, @RequestParam int idPlan,
                                  @RequestParam String metodoPago) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(idEstudiante);
        Plan plan = planService.obtenerPlanPorId(idPlan);

        return compraService.registrarCompra(estudiante, plan, metodoPago);
    }

    @GetMapping("/compras/{idEstudiante}")
    public List<Compra> obtenerComprasPorEstudiante(@PathVariable int idEstudiante) {
        return compraService.obtenerComprasPorEstudiante(idEstudiante);
    }

    @GetMapping("/planes")
    public List<Plan> obtenerPlanes() {
        return planService.obtenerTodosLosPlanes();
    }
}
