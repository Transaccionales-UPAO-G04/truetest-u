package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mentores")
public class MentorController {

    // Inyección de dependencias usando Lombok
    private final MentorService mentorService;

    // Obtener todos los mentores
    @GetMapping
    public ResponseEntity<List<Mentor>> findAll() {
        List<Mentor> mentores = mentorService.findAll();
        return ResponseEntity.ok(mentores);
    }

    // Obtener un mentor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mentor> findById(@PathVariable int id) {
        Mentor mentor = mentorService.findById(id);
        return ResponseEntity.ok(mentor);
    }

    // Obtener mentores por especialidad
    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<List<Mentor>> findByEspecialidad(@PathVariable("especialidad") String especialidad) {
        List<Mentor> resultadoEspecialidad = mentorService.findByEspecialidad(especialidad);
        if (resultadoEspecialidad.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Manteniendo el control detallado
        }
        return ResponseEntity.ok(resultadoEspecialidad);  // Respuesta simplificada
    }

    // Crear un nuevo mentor
    @PostMapping
    public ResponseEntity<Mentor> createMentor(@RequestBody Mentor mentor) {
        Mentor nuevoMentor = mentorService.createMentor(mentor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMentor);  // Devuelve 201 Created
    }

    // Actualizar un mentor existente
    @PutMapping("/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable int id, @RequestBody Mentor mentorDetails) {
        Mentor mentorActualizado = mentorService.updateMentor(id, mentorDetails);
        return ResponseEntity.ok(mentorActualizado);  // Devuelve el mentor actualizado con 200 OK
    }

    // Eliminar un mentor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable int id) {
        mentorService.deleteMentor(id);
        return ResponseEntity.noContent().build();  // Devuelve 204 No Content
    }

    // Recomendaciones de mentores por especialidad y experiencia
    @GetMapping("/recomendaciones")
    public ResponseEntity<List<Mentor>> recomendarMentores(@RequestParam String especialidad,
                                                           @RequestParam int minExperiencia,
                                                           @RequestParam int maxExperiencia) {
        List<Mentor> mentoresRecomendados = mentorService.recomendarMentoresPorEspecialidad(especialidad, minExperiencia, maxExperiencia);
        return ResponseEntity.ok(mentoresRecomendados);  // Respuesta optimizada
    }

    // Recomendaciones de mentores similares basadas en un mentor existente
    @GetMapping("/recomendaciones-similares/{mentorId}")
    public ResponseEntity<List<Mentor>> recomendarMentoresSimilares(@PathVariable int mentorId) {
        Mentor mentor = mentorService.findById(mentorId);
        List<Mentor> mentoresSimilares = mentorService.recomendarMentoresPorEspecialidad(
                mentor.getEspecialidad(), mentor.getExperiencia() - 2, mentor.getExperiencia() + 2);
        return ResponseEntity.ok(mentoresSimilares);  // Devuelve mentores similares
    }
}

