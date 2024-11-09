package grupo04.truetestu.api;

import grupo04.truetestu.dto.ReseñaDTO;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Reseña;
import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.service.EstudianteService;
import grupo04.truetestu.service.ReseñaService;
import grupo04.truetestu.service.MentorService;
import io.swagger.v3.oas.annotations.Operation; // Importa la anotación
import io.swagger.v3.oas.annotations.Parameter; // Importa la anotación
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
    private EstudianteService estudianteService;
    @Autowired
    private MentorService mentorService;

    // Obtener todas las reseñas
    @Operation(summary = "Obtener todas las reseñas",
            description = "Devuelve una lista de todas las reseñas disponibles.")
    @GetMapping
    public ResponseEntity<List<ReseñaDTO>> getAllReseñas() {
        List<ReseñaDTO> reseñas = reseñaService.findAll();
        return ResponseEntity.ok(reseñas);
    }

    // Obtener una reseña por ID
    @Operation(summary = "Obtener una reseña por ID",
            description = "Devuelve una reseña específica por su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ReseñaDTO> getReseñaById(@PathVariable int id) {
        ReseñaDTO reseña = reseñaService.findById(id);
        return ResponseEntity.ok(reseña);
    }

    // Crear una nueva reseña asociada a un mentor
    /*@Operation(summary = "Crear una nueva reseña",
            description = "Crea una nueva reseña asociada a un mentor específico.")
    @PostMapping("/{idMentor}/crear-reseña")
    public ResponseEntity<Reseña> createReseña(@PathVariable int idMentor, @RequestParam int idEstudiante,
                                               @RequestBody Reseña reseña) {
        // Validar que el mentor existe
        Mentor mentor = mentorService.findById(idMentor);

        Estudiante estudiante = estudianteService.findById(idEstudiante);
        // Asignar el mentor a la reseña
        reseña.setMentor(mentor);
        reseña.setEstudiante(estudiante);

        // Guardar la reseña en la base de datos
        Reseña nuevaReseña = reseñaService.createReseña(reseña);
        return new ResponseEntity<>(nuevaReseña, HttpStatus.CREATED);
    }*/

    // Eliminar una reseña por ID
    @Operation(summary = "Eliminar una reseña por ID",
            description = "Elimina una reseña específica por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReseña(@PathVariable int id) {
        reseñaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
