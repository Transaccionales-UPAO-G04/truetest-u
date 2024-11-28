package grupo04.truetestu.api;

import grupo04.truetestu.dto.ReseñaDTO;
import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.service.ReseñaService;
import grupo04.truetestu.service.MentorService;
import grupo04.truetestu.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation; // Importa la anotación
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
    private UsuarioService usuarioService;
    @Autowired
    private MentorService mentorService;

    // Obtener todas las reseñas
    @Operation(summary = "Obtener todas las reseñas",
            description = "Devuelve una lista de todas las reseñas disponibles segun el mentor.")
    @GetMapping("/{idMentor}/")
    @PreAuthorize("hasAnyRole('ESTUDIANTE', 'MENTOR')")
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

        return new ResponseEntity<>(reseñaService.createReseña(idMentor,idEstudiante,reseñaDTO), HttpStatus.CREATED);
    }

    // Eliminar una reseña por ID
    @Operation(summary = "Eliminar una reseña por ID",
            description = "Elimina una reseña específica por su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReseña(@PathVariable int id) {

            reseñaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
}
