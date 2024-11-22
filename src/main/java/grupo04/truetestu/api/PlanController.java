package grupo04.truetestu.api;

import grupo04.truetestu.service.impl.PlanServiceImpl;
import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.dto.PagoCaptureResponse;
import grupo04.truetestu.dto.PagoOrderResponse;
import grupo04.truetestu.service.impl.CheckoutServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private CheckoutServiceImpl checkoutService;  // Usamos CheckoutService en lugar de PagoServiceImpl

    // Endpoint para obtener la lista de planes
    @Operation(summary = "Obtener la lista de planes", description = "Devuelve una lista de todos los planes disponibles.")
    @GetMapping
    public List<Plan> obtenerPlanes() {
        return planService.obtenerTodosLosPlanes();
    }

    // Endpoint para crear una orden de pago
    @Operation(summary = "Crear una orden de pago", description = "Crea una orden de pago para activar el plan solicitado.")
    @PostMapping("/crear-orden")
    public ResponseEntity<PagoOrderResponse> crearOrdenDePago(
            @RequestParam Integer pagoId,
            @RequestParam String returnUrl,
            @RequestParam String cancelUrl) {
        try {
            PagoOrderResponse response = checkoutService.createPago(pagoId, returnUrl, cancelUrl);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para capturar el pago
    @Operation(summary = "Capturar el pago", description = "Captura el pago después de que se haya creado la orden.")
    @PostMapping("/capturar-pago")
    public ResponseEntity<PagoCaptureResponse> capturarPago(
            @RequestParam String orderId) {
        try {
            PagoCaptureResponse response = checkoutService.capturePago(orderId);
            if (response.isCompleted()) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para agregar un nuevo plan
    @Operation(summary = "Agregar un nuevo plan", description = "Agrega un nuevo plan al sistema.")
    @PostMapping
    public ResponseEntity<Plan> agregarPlan(@RequestBody Plan plan) {
        Plan nuevoPlan = planService.agregarPlan(plan);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPlan);
    }

    // Endpoint para eliminar un plan
    @Operation(summary = "Eliminar un plan", description = "Elimina un plan del sistema por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPlan(@PathVariable("id") int id) {
        planService.eliminarPlan(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para modificar un plan existente
    @Operation(summary = "Modificar un plan existente", description = "Modifica la información de un plan existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Plan> modificarPlan(@PathVariable("id") int id, @RequestBody Plan plan) {
        Plan planActualizado = planService.modificarPlan(id, plan);
        return ResponseEntity.ok(planActualizado);
    }

    // Endpoint para obtener un plan por su ID
    @Operation(summary = "Obtener un plan por su ID", description = "Devuelve la información de un plan por su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Plan> obtenerPlanPorId(@PathVariable("id") int id) {
        Plan plan = planService.obtenerPlanPorId(id);
        return ResponseEntity.ok(plan);
    }
}
