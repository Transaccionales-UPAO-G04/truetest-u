package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentores")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    // Obtener todos los mentores
    @GetMapping
    public List<Mentor> findAll() {
        return mentorService.findAll();
    }

    // Obtener un mentor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mentor> findById(@PathVariable int id) {
        Mentor mentor = mentorService.findById(id);
        return ResponseEntity.ok(mentor);
    }

    // Crear un nuevo mentor
    @PostMapping
    public ResponseEntity<Mentor> createMentor(@RequestBody Mentor mentor) {
        Mentor nuevoMentor = mentorService.createMentor(mentor);
        return ResponseEntity.ok(nuevoMentor);
    }

    // Actualizar un mentor existente
    @PutMapping("/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable int id, @RequestBody Mentor mentorDetails) {
        Mentor mentorActualizado = mentorService.updateMentor(id, mentorDetails);
        return ResponseEntity.ok(mentorActualizado);
    }

    // Eliminar un mentor
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMentor(@PathVariable int id) {
        mentorService.deleteMentor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
