package grupo04.truetestu.api;

import grupo04.truetestu.dto.MentorDetailsDTO;
import grupo04.truetestu.mapper.MentorMapper;
import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.service.MentorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mentores")

public class MentorController {

    @Autowired
    private MentorService mentorService;
    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private MentorMapper mentorMapper;

    // Obtener todos los mentores
    @Operation(summary = "Obtener todos los mentores",
            description = "Devuelve una lista de todos los mentores disponibles.")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<MentorDetailsDTO> findAll() {
        List<Mentor> mentores = mentorRepository.findAll();
        return mentores.stream()
                .map(mentorMapper::toDTO)
                .toList();
    }

    // Obtener un mentor por ID
    @Operation(summary = "Obtener un mentor por ID",
            description = "Devuelve un mentor específico dado su ID.")
    @Parameter(description = "ID del mentor a buscar")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<MentorDetailsDTO> findById(@PathVariable int id) {
        MentorDetailsDTO mentor = mentorService.findById(id);
        return ResponseEntity.ok(mentor);
    }

    @Operation(summary = "Buscar mentores por especialidad",
            description = "Devuelve una lista de mentores que tienen la especialidad especificada.")
    @Parameter(description = "Especialidad del mentor a buscar")
    @GetMapping("/especialidad/{especialidad}")
    @PreAuthorize("hasAnyRole('ESTUDIANTE','MENTOR')")
    public ResponseEntity<List<MentorDetailsDTO>> findByEspecialidad(@PathVariable("especialidad") String especialidad) {
        List<MentorDetailsDTO> resultadoEspecialidad = mentorService.findByEspecialidad(especialidad);
        if (resultadoEspecialidad.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resultadoEspecialidad, HttpStatus.OK);
    }

    // Crear un nuevo mentor
    @Operation(summary = "Crear un nuevo mentor",
            description = "Registra un nuevo mentor en el sistema.")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<MentorDetailsDTO> createMentor(@RequestBody @Valid MentorDetailsDTO mentorDetailsDTO) {
        MentorDetailsDTO newMentor = mentorService.createMentor(mentorDetailsDTO);
        return new ResponseEntity<>(newMentor, HttpStatus.CREATED);
    }

    // Actualizar un mentor existente
    @Operation(summary = "Actualizar un mentor existente",
            description = "Actualiza la información de un mentor existente dado su ID.")
    @Parameter(description = "ID del mentor a actualizar")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<MentorDetailsDTO> updateMentor(@PathVariable int id, @RequestBody MentorDetailsDTO mentorDetailsDTO) {
        MentorDetailsDTO mentorActualizado = mentorService.updateMentor(id, mentorDetailsDTO);
        return new ResponseEntity<>(mentorActualizado, HttpStatus.OK);
    }

    // Eliminar un mentor
    @Operation(summary = "Eliminar un mentor",
            description = "Elimina un mentor del sistema dado su ID.")
    @Parameter(description = "ID del mentor a eliminar")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteMentor(@PathVariable int id) {
        mentorService.deleteMentor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
