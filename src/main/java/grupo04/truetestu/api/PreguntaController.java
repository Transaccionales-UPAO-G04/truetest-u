package grupo04.truetestu.api;

import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.service.PreguntaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pregunta")
public class PreguntaController {

    private final PreguntaService preguntaService;

    // Crear una nueva pregunta
    @PostMapping
    public ResponseEntity<PreguntaDTO> crearPregunta(@RequestBody PreguntaDTO preguntaDTO) {
        PreguntaDTO nuevaPregunta = preguntaService.create(preguntaDTO);
        return new ResponseEntity<>(nuevaPregunta, HttpStatus.CREATED);
    }

    // Obtener todas las preguntas
    @GetMapping
    public ResponseEntity<List<PreguntaDTO>> obtenerTodasLasPreguntas() {
        List<PreguntaDTO> preguntas = preguntaService.getAll();
        return ResponseEntity.ok(preguntas);
    }

    // Obtener una pregunta por ID
    @GetMapping("/{id}")
    public ResponseEntity<PreguntaDTO> obtenerPreguntaPorId(@PathVariable Integer id) {
        return preguntaService.findByID(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar una pregunta
    @PutMapping("/{id}")
    public ResponseEntity<PreguntaDTO> actualizarPregunta(@PathVariable Integer id,
                                                          @RequestBody PreguntaDTO preguntaDTO) {
        return preguntaService.update(id, preguntaDTO)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar una pregunta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPregunta(@PathVariable Integer id) {
        preguntaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

