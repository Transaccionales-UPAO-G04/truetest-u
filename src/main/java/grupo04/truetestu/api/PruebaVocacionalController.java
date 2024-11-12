package grupo04.truetestu.api;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.service.PruebaVocacionalService;
import grupo04.truetestu.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("prueba/vocacional")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ESTUDIANTE')")
@Tag(name = "Prueba Vocacional", description = "API para gestionar pruebas vocacionales")
public class PruebaVocacionalController {

    private final PruebaVocacionalService pruebaVocacionalService;

    @Operation(summary = "Crear Prueba Vocacional",
            description = "Crea una nueva prueba vocacional y retorna los datos creados.")
    @PostMapping("/realizar")
    public ResponseEntity<PruebaVocacionalDTO> realizarPruebaVocacional(
            @RequestBody PruebaVocacionalDTO pruebaVocacionalDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pruebaVocacionalService.crearPruebaVocacional(pruebaVocacionalDTO));
    }

    @Operation(summary = "Listar todas las Pruebas Vocacionales",
            description = "Devuelve una lista de todas las pruebas vocacionales disponibles.")
    @GetMapping("/listar")
    public ResponseEntity<List<PruebaVocacionalDTO>> listarPruebasVocacionales() {
        return ResponseEntity.ok(pruebaVocacionalService.obtenerPruebasVocacionales());
    }

    @Operation(summary = "Listar Pruebas Vocacionales Paginadas",
            description = "Devuelve una lista paginada de pruebas vocacionales.")
    @GetMapping("/listar/paginado")
    public ResponseEntity<Page<PruebaVocacionalDTO>> listarPruebasVocacionalesPaginado(
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(pruebaVocacionalService.paginate(pageable));
    }

    @Operation(summary = "Obtener Prueba Vocacional por ID",
            description = "Devuelve una prueba vocacional específica por su ID.")
    @GetMapping("/listar/{id}")
    public ResponseEntity<PruebaVocacionalDTO> obtenerPruebaVocacional(
            @Parameter(description = "ID de la prueba vocacional")
            @PathVariable Long id) {
        return ResponseEntity.ok(pruebaVocacionalService.obtenerPruebaVocacionalPorId(id));
    }

    @Operation(summary = "Actualizar Prueba Vocacional",
            description = "Actualiza una prueba vocacional existente por su ID.")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PruebaVocacionalDTO> actualizarPruebaVocacional(
            @Parameter(description = "ID de la prueba vocacional")
            @PathVariable Long id,
            @RequestBody PruebaVocacionalDTO pruebaVocacionalDTO) {
        return ResponseEntity.ok(pruebaVocacionalService.actualizarPruebaVocacional(id, pruebaVocacionalDTO));
    }

    @Operation(summary = "Eliminar Prueba Vocacional",
            description = "Elimina una prueba vocacional por su ID.")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPruebaVocacional(
            @Parameter(description = "ID de la prueba vocacional")
            @PathVariable Long id) {
        pruebaVocacionalService.eliminarPruebaVocacional(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Obtener Preguntas",
            description = "Obtiene la lista de preguntas disponibles para la prueba vocacional.")
    @GetMapping("/preguntas")
    public ResponseEntity<List<PreguntaDTO>> obtenerPreguntas() {
        return ResponseEntity.ok(pruebaVocacionalService.obtenerPreguntas());
    }

    @Operation(summary = "Guardar Respuesta",
            description = "Guarda una respuesta individual de la prueba vocacional.")
    @PostMapping("/respuesta")
    public ResponseEntity<Void> guardarRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
        pruebaVocacionalService.guardarRespuesta(respuestaDTO);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Calcular Resultado",
            description = "Calcula el resultado final de la prueba vocacional basado en las respuestas proporcionadas.")
    @PostMapping("/calcular-resultado")
    public ResponseEntity<PruebaVocacionalDTO> calcularResultado(
            @RequestBody List<RespuestaDTO> respuestas) {
        return ResponseEntity.ok(pruebaVocacionalService.calcularResultado(respuestas));
    }

    // Manejador de excepciones para recursos no encontrados
    @ExceptionHandler(grupo04.truetestu.exception.ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(grupo04.truetestu.exception.ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}





