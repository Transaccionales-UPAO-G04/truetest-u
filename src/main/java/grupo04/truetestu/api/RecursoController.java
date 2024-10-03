package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Recurso;
import grupo04.truetestu.service.RecursoService;
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

    @GetMapping
    public ResponseEntity<List<Recurso>> obtenerTodos() {
        List<Recurso> recursos = recursoService.obtenerTodos();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Recurso> obtenerPorId(@PathVariable int id) {
        return recursoService.obtenerPorId(id)
                .map(recurso -> new ResponseEntity<>(recurso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Recurso> guardar(@RequestBody Recurso recurso) {
        Recurso nuevoRecurso = recursoService.guardar(recurso);
        return new ResponseEntity<>(nuevoRecurso, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        recursoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/gratis")
    public ResponseEntity<List<Recurso>> obtenerRecursosGratis() {
        List<Recurso> recursos = recursoService.obtenerRecursosGratis();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @GetMapping("/premium")
    public ResponseEntity<List<Recurso>> obtenerRecursosPremium() {
        List<Recurso> recursos = recursoService.obtenerRecursosPremium();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @GetMapping("/premium/{especialidad}")
    public ResponseEntity<List<Recurso>> obtenerRecursosPremiumPorEspecialidad(@PathVariable String especialidad) {
        List<Recurso> recursos = recursoService.obtenerRecursosPremiumPorEspecialidad(especialidad);
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @GetMapping("/gratis/{especialidad}")
    public ResponseEntity<List<Recurso>> obtenerRecursosGratisPorEspecialidad(@PathVariable String especialidad) {
        List<Recurso> recursos = recursoService.obtenerRecursosGratisPorEspecialidad(especialidad);
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }


    @PostMapping("/{id}/favorito")
    public ResponseEntity<Recurso> cambiarEstadoFavorito(@PathVariable int id) {
        Recurso recursoActualizado = recursoService.cambiarEstadoFavorito(id);
        return ResponseEntity.ok(recursoActualizado);
    }
}
