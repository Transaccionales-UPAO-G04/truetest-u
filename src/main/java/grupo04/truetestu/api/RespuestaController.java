package grupo04.truetestu.controller;

import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.service.RespuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/respuesta")
public class RespuestaController {

    private final RespuestaService respuestaService;

    // Crear una nueva respuesta
    @PostMapping
    public ResponseEntity<RespuestaDTO> crearRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
        RespuestaDTO nuevaRespuesta = respuestaService.create(respuestaDTO);
        return new ResponseEntity<>(nuevaRespuesta, HttpStatus.CREATED);
    }

    // Obtener todas las respuestas
    @GetMapping
    public ResponseEntity<List<RespuestaDTO>> obtenerTodasLasRespuestas() {
        List<RespuestaDTO> respuestas = respuestaService.getAll();
        return ResponseEntity.ok(respuestas);
    }

    // Obtener una respuesta por ID
    @GetMapping("/{id}")
    public ResponseEntity<RespuestaDTO> obtenerRespuestaPorId(@PathVariable Integer id) {
        return respuestaService.findByID(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar una respuesta
    @PutMapping("/{id}")
    public ResponseEntity<RespuestaDTO> actualizarRespuesta(@PathVariable Integer id,
                                                            @RequestBody RespuestaDTO respuestaDTO) {
        return respuestaService.update(id, respuestaDTO)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar una respuesta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Integer id) {
        respuestaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

