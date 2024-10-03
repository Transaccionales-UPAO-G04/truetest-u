package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")

public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.findAll();
    }

    // Endpoint para cambiar el plan de un estudiante
    @PatchMapping("/{id}/cambiar-plan")
    public ResponseEntity<?> cambiarPlan(@PathVariable int id, @RequestParam EstadoPlan nuevoPlan) {
        estudianteService.cambiarPlan(id, nuevoPlan);
        return ResponseEntity.ok().build();
    }

    // Eliminar un mentor
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstudiante(@PathVariable int id) {
        estudianteService.deleteEstudiante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable int id,
                                                       @RequestBody Estudiante estudiante) {
        Estudiante updateEstudiante = estudianteService.update(id, estudiante);
        return new ResponseEntity<>(updateEstudiante, HttpStatus.OK);
    }

}