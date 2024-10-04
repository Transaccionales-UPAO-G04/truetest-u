package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoPlan;  // IMPORTAR EstadoPlan
import grupo04.truetestu.service.impl.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contenido")
public class ContenidoController {

    @Autowired
    private EstudianteServiceImpl estudianteService;  // Servicio para obtener el estado del estudiante

    // Endpoint para obtener contenido exclusivo
    @GetMapping("/exclusivo")
    public ResponseEntity<String> obtenerContenidoExclusivo(@RequestParam int idEstudiante) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(idEstudiante);

        // Verificar si el estudiante es premium
        if (estudiante.getEstadoPlan() == EstadoPlan.PREMIUM) {
            return ResponseEntity.ok("Contenido exclusivo para usuarios premium");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: solo disponible para usuarios premium");
        }
    }
}
