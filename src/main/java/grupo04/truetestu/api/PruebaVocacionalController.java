package grupo04.truetestu.api;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.service.PruebaVocacionalService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("prueba/vocacional")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ESTUDIANTE')")
public class PruebaVocacionalController {

    private final PruebaVocacionalService pruebaVocacionalService;

    @Operation(summary = "Crear Prueba Vocacional",
            description = "Crea una nueva prueba vocacional.")
    @PostMapping("/realizar")
    public ResponseEntity<String> realizarPruebaVocacional(@RequestBody PruebaVocacionalDTO pruebaVocacionalDTO) {
        pruebaVocacionalService.create(pruebaVocacionalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Prueba Vocacional creada exitosamente");
    }

    @Operation(summary = "Listar todas las Pruebas Vocacionales",
            description = "Devuelve una lista de todas las pruebas vocacionales.")
    @GetMapping("/listar")
    public ResponseEntity<List<PruebaVocacionalDTO>> getAllPruebaVocacional() {
        List<PruebaVocacionalDTO> pruebas = pruebaVocacionalService.getAll();
        return ResponseEntity.ok(pruebas);
    }

    @Operation(summary = "Listar Pruebas Vocacionales Paginadas",
            description = "Devuelve una lista de pruebas vocacionales paginadas.")
    @GetMapping("/listar/paginado")
    public ResponseEntity<Page<PruebaVocacionalDTO>> getAllPruebaVocacionalPaginado(
            @PageableDefault(size = 10) Pageable pageable) {
        Page<PruebaVocacionalDTO> page = pruebaVocacionalService.paginate(pageable);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Obtener Prueba Vocacional por ID",
            description = "Devuelve una prueba vocacional específica por su ID.")
    @GetMapping("/listar/{id}")
    public ResponseEntity<PruebaVocacionalDTO> obtenerPruebaVocacional(@PathVariable Integer id) {
        return pruebaVocacionalService.findByID(id)
                .map(prueba -> ResponseEntity.ok(prueba))
                .orElseThrow(() -> new ResourceNotFoundException("Prueba Vocacional no encontrada con id: " + id));
    }

    @Operation(summary = "Actualizar Prueba Vocacional",
            description = "Actualiza una prueba vocacional existente por su ID.")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PruebaVocacionalDTO> actualizarPruebaVocacional(
            @PathVariable Integer id,
            @RequestBody PruebaVocacionalDTO pruebaVocacionalDTO) {
        return pruebaVocacionalService.update(id, pruebaVocacionalDTO)
                .map(prueba -> ResponseEntity.ok(prueba))
                .orElseThrow(() -> new ResourceNotFoundException("Prueba Vocacional no encontrada con id: " + id));
    }

    @Operation(summary = "Eliminar Prueba Vocacional",
            description = "Elimina una prueba vocacional existente por su ID.")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPruebaVocacional(@PathVariable Integer id) {
        pruebaVocacionalService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Prueba Vocacional eliminada exitosamente");
    }
}