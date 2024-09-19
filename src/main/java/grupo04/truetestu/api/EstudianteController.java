package grupo04.truetestu.api;

import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiantes")

public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // Endpoint para inhabilitar la cuenta de un estudiante
    @PatchMapping("/{id}/inhabilitar")
    public ResponseEntity<?> inhabilitarEstudiante(@PathVariable int id) {
        estudianteService.inhabilitarCuenta(id);
        return ResponseEntity.ok().build();
    }

    // Endpoint para cambiar el plan de un estudiante
    @PatchMapping("/{id}/cambiar-plan")
    public ResponseEntity<?> cambiarPlan(@PathVariable int id, @RequestParam EstadoPlan nuevoPlan) {
        estudianteService.cambiarPlan(id, nuevoPlan);
        return ResponseEntity.ok().build();
    }

}