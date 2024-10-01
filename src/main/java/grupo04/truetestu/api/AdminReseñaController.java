package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Reseña;
import grupo04.truetestu.service.ReseñaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reseña")
public class AdminReseñaController {
    private final ReseñaService reseñaService;

    @GetMapping
    public List<Reseña> findAll() {
        return reseñaService.findAll();
    }

    // Obtener una reseña por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reseña> findById(@PathVariable int id) {
        Reseña reseña = reseñaService.findById(id);
        return ResponseEntity.ok(reseña);
    }

    // Crear una nueva reseña
    @PostMapping
    public ResponseEntity<Reseña> create(@RequestBody Reseña reseña) {
        Reseña nuevaReseña = reseñaService.createReseña(reseña);
        return ResponseEntity.ok(nuevaReseña);
    }

    // Actualizar una reseña existente
    @PutMapping("/{id}")
    public ResponseEntity<Reseña> update(@PathVariable int id, @RequestBody Reseña reseñaDetails) {
        Reseña reseñaActualizada = reseñaService.update(id, reseñaDetails);
        return ResponseEntity.ok(reseñaActualizada);
    }

    // Eliminar una reseña por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        reseñaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
