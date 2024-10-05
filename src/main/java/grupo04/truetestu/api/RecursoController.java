package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Recurso;
import grupo04.truetestu.service.RecursoService;
import io.swagger.v3.oas.annotations.Operation; // Importa la anotación
import io.swagger.v3.oas.annotations.Parameter; // Importa la anotación
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recursos")
public class RecursoController {

    private final RecursoService recursoService;

    @Operation(summary = "Obtener todos los recursos",
            description = "Devuelve una lista de todos los recursos disponibles.")
    @GetMapping
    public ResponseEntity<List<Recurso>> obtenerTodos() {
        List<Recurso> recursos = recursoService.obtenerTodos();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }


    @Operation(summary = "Obtener recurso por ID",
            description = "Devuelve un recurso específico por su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Recurso> obtenerPorId(@PathVariable int id) {
        return recursoService.obtenerPorId(id)
                .map(recurso -> new ResponseEntity<>(recurso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Guardar nuevo recurso",
            description = "Crea un nuevo recurso y lo almacena en la base de datos.")
    @PostMapping
    public ResponseEntity<Recurso> guardar(@RequestBody Recurso recurso) {
        Recurso nuevoRecurso = recursoService.guardar(recurso);
        return new ResponseEntity<>(nuevoRecurso, HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar recurso por ID",
            description = "Elimina un recurso específico por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        recursoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Obtener recursos gratis",
            description = "Devuelve una lista de recursos que son gratuitos.")
    @GetMapping("/gratis")
    public ResponseEntity<List<Recurso>> obtenerRecursosGratis() {
        List<Recurso> recursos = recursoService.obtenerRecursosGratis();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @Operation(summary = "Obtener recursos premium",
            description = "Devuelve una lista de recursos que son premium.")
    @GetMapping("/premium")
    public ResponseEntity<List<Recurso>> obtenerRecursosPremium() {
        List<Recurso> recursos = recursoService.obtenerRecursosPremium();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @Operation(summary = "Obtener recursos premium por especialidad",
            description = "Devuelve una lista de recursos premium filtrados por especialidad.")
    @GetMapping("/premium/{especialidad}")
    public ResponseEntity<List<Recurso>> obtenerRecursosPremiumPorEspecialidad(@PathVariable String especialidad) {
        List<Recurso> recursos = recursoService.obtenerRecursosPremiumPorEspecialidad(especialidad);
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @Operation(summary = "Obtener recursos gratis por especialidad",
            description = "Devuelve una lista de recursos gratis filtrados por especialidad.")
    @GetMapping("/gratis/{especialidad}")
    public ResponseEntity<List<Recurso>> obtenerRecursosGratisPorEspecialidad(@PathVariable String especialidad) {
        List<Recurso> recursos = recursoService.obtenerRecursosGratisPorEspecialidad(especialidad);
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @Operation(summary = "Cambiar estado a favorito",
            description = "Cambia el estado de un recurso a favorito.")
    @PostMapping("/{id}/favorito")
    public ResponseEntity<Recurso> cambiarEstadoFavorito(@PathVariable int id) {
        Recurso recursoActualizado = recursoService.cambiarEstadoFavorito(id);
        return ResponseEntity.ok(recursoActualizado);
    }
}
