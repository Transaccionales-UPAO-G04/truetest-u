package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Especialidad;
import grupo04.truetestu.service.VisualizarEspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/especialidades")
public class VisualizarEspecialidadController {

    private final VisualizarEspecialidadService especialidadService;

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> findById(@PathVariable Integer id) {
        Especialidad especialidad = especialidadService.findByID(id);
        return ResponseEntity.ok(especialidad);
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> getAll() {
        List<Especialidad> especialidades = especialidadService.getAll();
        return ResponseEntity.ok(especialidades);
    }
}

