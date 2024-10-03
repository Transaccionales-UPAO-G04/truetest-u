package grupo04.truetestu.api;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.service.PruebaVocacionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prueba/vocacional")
public class PruebaVocacionalController {

    private final PruebaVocacionalService pruebaVocacionalService;

    @PostMapping("/realizar")
    public ResponseEntity<PruebaVocacionalDTO> realizarPruebaVocacional(@RequestBody PruebaVocacionalDTO pruebaVocacionalDto) {
        PruebaVocacionalDTO savedDto = pruebaVocacionalService.create(pruebaVocacionalDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PruebaVocacionalDTO>> getAllPruebas() {
        List<PruebaVocacionalDTO> pruebas = pruebaVocacionalService.getAll();
        return ResponseEntity.ok(pruebas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PruebaVocacionalDTO> getPruebaById(@PathVariable Integer id) {
        return pruebaVocacionalService.findByID(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PruebaVocacionalDTO> updatePruebaVocacional(@PathVariable Integer id,
                                                                      @RequestBody PruebaVocacionalDTO pruebaVocacionalDto) {
        return pruebaVocacionalService.update(id, pruebaVocacionalDto)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePruebaVocacional(@PathVariable Integer id) {
        pruebaVocacionalService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}











