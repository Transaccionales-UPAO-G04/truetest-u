package grupo04.truetestu.controller;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.service.ResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/resultados")
public class ResultadoPruebaController {

    private final ResultadoPruebaService resultadoPruebaService;

    @PostMapping
    public ResponseEntity<ResultadoPrueba> create(@RequestBody ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba createdResultado = resultadoPruebaService.create(resultadoPrueba);
        return new ResponseEntity<>(createdResultado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> findById(@PathVariable Integer id) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaService.findByID(id);
        return ResponseEntity.ok(resultadoPrueba);
    }

    @GetMapping
    public ResponseEntity<List<ResultadoPrueba>> getAll() {
        List<ResultadoPrueba> resultados = resultadoPruebaService.getAll();
        return ResponseEntity.ok(resultados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> update(@PathVariable Integer id, @RequestBody ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba updatedResultado = resultadoPruebaService.update(id, resultadoPrueba);
        return ResponseEntity.ok(updatedResultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        resultadoPruebaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

