package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Reseña;
import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.service.ReseñaService;
import grupo04.truetestu.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reseñas")
public class ReseñaController {

    @Autowired
    private ReseñaService reseñaService;

    @Autowired
    private MentorService mentorService;

    // Obtener todas las reseñas
    @GetMapping
    public ResponseEntity<List<Reseña>> getAllReseñas() {
        List<Reseña> reseñas = reseñaService.findAll();
        return ResponseEntity.ok(reseñas);
    }

    // Obtener una reseña por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reseña> getReseñaById(@PathVariable int id) {
        Reseña reseña = reseñaService.findById(id);
        return ResponseEntity.ok(reseña);
    }

    // Crear una nueva reseña asociada a un mentor
    @PostMapping("/{idMentor}/crear-reseña/")
    public ResponseEntity<Reseña> createReseña(@PathVariable int idMentor,
                                               @RequestBody Reseña reseña) {
        // Validar que el mentor existe
        Mentor mentor = mentorService.findById(idMentor);

        // Asignar el mentor a la reseña
        reseña.setMentor(mentor);

        // Guardar la reseña en la base de datos
        Reseña nuevaReseña = reseñaService.createReseña(reseña);
        return new ResponseEntity<>(nuevaReseña, HttpStatus.CREATED);
    }

    // Eliminar una reseña por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReseña(@PathVariable int id) {
        reseñaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
