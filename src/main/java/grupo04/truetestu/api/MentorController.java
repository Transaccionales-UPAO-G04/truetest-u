package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.service.MentorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mentores")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    // Obtener todos los mentores
    @Operation(summary = "Obtener todos los mentores",
            description = "Devuelve una lista de todos los mentores disponibles.")
    @GetMapping
    public List<Mentor> findAll() {
        return mentorService.findAll();
    }

    // Obtener un mentor por ID
    @Operation(summary = "Obtener un mentor por ID",
            description = "Devuelve un mentor específico dado su ID.")
    @Parameter(description = "ID del mentor a buscar")
    @GetMapping("/{id}")
    public ResponseEntity<Mentor> findById(@PathVariable int id) {
        Mentor mentor = mentorService.findById(id);
        return ResponseEntity.ok(mentor);
    }

    @Operation(summary = "Buscar mentores por especialidad",
            description = "Devuelve una lista de mentores que tienen la especialidad especificada.")
    @Parameter(description = "Especialidad del mentor a buscar")
    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<List<Mentor>> findByEspecialidad(@PathVariable("especialidad") String especialidad) {
        List<Mentor> resultadoEspecialidad = mentorService.findByEspecialidad(especialidad);
        if (resultadoEspecialidad.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resultadoEspecialidad, HttpStatus.OK);
    }

    // Crear un nuevo mentor
    @Operation(summary = "Crear un nuevo mentor",
            description = "Registra un nuevo mentor en el sistema.")
    @PostMapping
    public ResponseEntity<Mentor> createMentor(@RequestBody @Valid Mentor mentor) {
        Mentor newMentor = mentorService.createMentor(mentor);
        return new ResponseEntity<>(newMentor, HttpStatus.CREATED);
    }

    // Actualizar un mentor existente
    @Operation(summary = "Actualizar un mentor existente",
            description = "Actualiza la información de un mentor existente dado su ID.")
    @Parameter(description = "ID del mentor a actualizar")
    @PutMapping("/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable int id, @RequestBody Mentor mentorDetails) {
        Mentor mentorActualizado = mentorService.updateMentor(id, mentorDetails);
        return ResponseEntity.ok(mentorActualizado);
    }

    // Eliminar un mentor
    @Operation(summary = "Eliminar un mentor",
            description = "Elimina un mentor del sistema dado su ID.")
    @Parameter(description = "ID del mentor a eliminar")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMentor(@PathVariable int id) {
        mentorService.deleteMentor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
