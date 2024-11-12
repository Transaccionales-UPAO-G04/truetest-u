package grupo04.truetestu.api;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.dto.MentorDetailsDTO;
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
import org.springframework.security.access.prepost.PreAuthorize;
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
            description = "Devuelve una lista de todas las reseñas disponibles segun el mentor.")
    @GetMapping("/{id}/")
    @PreAuthorize("hasAnyRole('ESTUDIANTE')")
    public ResponseEntity<List<ReseñaDTO>> getAllReseñasPorMentor(@PathVariable int idMentor) {

        List<ReseñaDTO> reseñas = reseñaService.findByMentorId(idMentor);
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
    @Operation(summary = "Crear una nueva reseña",
            description = "Crea una nueva reseña asociada a un mentor específico.")
    @PostMapping("/{idMentor}/crear-reseña")
    public ResponseEntity<ReseñaDTO> createReseña(@PathVariable int idMentor, @RequestParam int idEstudiante,
                                               @RequestBody ReseñaDTO reseñaDTO) {

        EstudianteDTO estudianteDTO = estudianteService.findById(idEstudiante);
        // Asignar al estudiante a la reseña
        reseñaDTO.setEstudianteDTO(estudianteDTO);

        // Guardar la reseña en la base de datos
        ReseñaDTO nuevaReseñaDTO = reseñaService.createReseña(new ReseñaDTO());
        return new ResponseEntity<>(nuevaReseñaDTO, HttpStatus.CREATED);
    }

    // Eliminar una reseña por ID
    @Operation(summary = "Eliminar una reseña por ID",
            description = "Elimina una reseña específica por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReseña(@PathVariable int id) {
        reseñaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
