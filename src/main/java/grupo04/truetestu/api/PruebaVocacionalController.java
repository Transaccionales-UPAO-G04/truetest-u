package grupo04.truetestu.api;

import grupo04.truetestu.Infra.exception.ResourceNotFoundException;
import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.service.PruebaVocacionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("prueba/vocacional")
public class PruebaVocacionalController {

    private final PruebaVocacionalService pruebaVocacionalService;

    @PostMapping("/realizar")
    public ResponseEntity<String> realizarPruebaVocacional(@RequestBody PruebaVocacionalDTO pruebaVocacionalDTO) {
        pruebaVocacionalService.create(pruebaVocacionalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Prueba Vocacional creada exitosamente");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PruebaVocacionalDTO>> getAllPruebaVocacional() {
        List<PruebaVocacionalDTO> pruebas = pruebaVocacionalService.getAll();
        return ResponseEntity.ok(pruebas);
    }

    @GetMapping("/listar/paginado")
    public ResponseEntity<Page<PruebaVocacionalDTO>> getAllPruebaVocacionalPaginado(
            @PageableDefault(size = 10) Pageable pageable) {
        Page<PruebaVocacionalDTO> page = pruebaVocacionalService.paginate(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<PruebaVocacionalDTO> obtenerPruebaVocacional(@PathVariable Integer id) {
        return pruebaVocacionalService.findByID(id)
                .map(prueba -> ResponseEntity.ok(prueba))
                .orElseThrow(() -> new ResourceNotFoundException("Prueba Vocacional no encontrada con id: " + id));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PruebaVocacionalDTO> actualizarPruebaVocacional(
            @PathVariable Integer id,
            @RequestBody PruebaVocacionalDTO pruebaVocacionalDTO) {
        return pruebaVocacionalService.update(id, pruebaVocacionalDTO)
                .map(prueba -> ResponseEntity.ok(prueba))
                .orElseThrow(() -> new ResourceNotFoundException("Prueba Vocacional no encontrada con id: " + id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPruebaVocacional(@PathVariable Integer id) {
        pruebaVocacionalService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Prueba Vocacional eliminada exitosamente");
    }
}







