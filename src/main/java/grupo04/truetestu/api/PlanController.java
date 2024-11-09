package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.model.entity.Pago;
import grupo04.truetestu.service.impl.PlanServiceImpl;
import grupo04.truetestu.service.impl.PagoServiceImpl;
import io.swagger.v3.oas.annotations.Operation; // Importa la anotación
import io.swagger.v3.oas.annotations.Parameter; // Importa la anotación
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planes")
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

    // Endpoint para agregar un nuevo plan
    @Operation(summary = "Agregar un nuevo plan",
            description = "Agrega un nuevo plan al sistema.")
    @PostMapping
    public ResponseEntity<Plan> agregarPlan(@RequestBody Plan plan) {
        Plan nuevoPlan = planService.agregarPlan(plan);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPlan);
    }

    // Endpoint para eliminar un plan
    @Operation(summary = "Eliminar un plan", description = "Elimina un plan del sistema por su ID.")
    @DeleteMapping("/{idPlan}")
    public ResponseEntity<Void> eliminarPlan(@PathVariable int idPlan) {
        planService.eliminarPlan(idPlan);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para modificar un plan existente
    @Operation(summary = "Modificar un plan existente", description = "Modifica la información de un plan existente.")
    @PutMapping("/{idPlan}")
    public ResponseEntity<Plan> modificarPlan(@PathVariable int idPlan, @RequestBody Plan plan) {
        Plan planActualizado = planService.modificarPlan(idPlan, plan);
        return ResponseEntity.ok(planActualizado);
    }

    // Endpoint para obtener un plan por su ID
    @Operation(summary = "Obtener un plan por su ID",
            description = "Devuelve la información de un plan por su ID.")
    @GetMapping("/{idPlan}")
    public ResponseEntity<Plan> obtenerPlanPorId(@PathVariable int idPlan) {
        Plan plan = planService.obtenerPlanPorId(idPlan);
        return ResponseEntity.ok(plan);
    }

}
