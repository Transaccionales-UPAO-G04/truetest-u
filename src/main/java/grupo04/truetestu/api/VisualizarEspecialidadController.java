package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Especialidad;
import grupo04.truetestu.service.VisualizarEspecialidadService;
import io.swagger.v3.oas.annotations.Operation; // Importa la anotación
import io.swagger.v3.oas.annotations.Parameter; // Importa la anotación
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

    @Operation(summary = "Obtener especialidad por ID",
            description = "Devuelve los detalles de una especialidad específica utilizando su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> findById(@PathVariable Integer id) {
        Especialidad especialidad = especialidadService.findByID(id);
        return ResponseEntity.ok(especialidad);
    }

    @Operation(summary = "Obtener todas las especialidades",
            description = "Devuelve una lista de todas las especialidades disponibles.")
    @GetMapping
    public ResponseEntity<List<Especialidad>> getAll() {
        List<Especialidad> especialidades = especialidadService.getAll();
        return ResponseEntity.ok(especialidades);
    }
}

