package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.service.ResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/resultados")
public class ResultadoPruebaController {

    private final ResultadoPruebaService ResultadoPruebaService;

    // Crear un nuevo ResultadoPrueba
    @PostMapping
    public ResponseEntity<ResultadoPrueba> create(@RequestBody ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba createdResultado = ResultadoPruebaService.create(resultadoPrueba);
        return new ResponseEntity<>(createdResultado, HttpStatus.CREATED);
    }

    // Buscar un ResultadoPrueba por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> findById(@PathVariable Integer id) {
        ResultadoPrueba resultadoPrueba = ResultadoPruebaService.findByID(id);
        return ResponseEntity.ok(resultadoPrueba);
    }

    // Obtener todos los ResultadosPrueba
    @GetMapping
    public ResponseEntity<List<ResultadoPrueba>> getAll() {
        List<ResultadoPrueba> resultados = ResultadoPruebaService.getAll();
        return ResponseEntity.ok(resultados);
    }

    // Actualizar un ResultadoPrueba por su ID
    @PutMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> update(@PathVariable Integer id, @RequestBody ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba updatedResultado = ResultadoPruebaService.update(id, resultadoPrueba);
        return ResponseEntity.ok(updatedResultado);
    }

    // Eliminar un ResultadoPrueba por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ResultadoPruebaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener ResultadosPrueba por el ID del estudiante
    @GetMapping("/estudiante/{id}")
    public ResponseEntity<?> getResultadoPruebaByEstudianteId(@PathVariable("id") int id) {
        Optional<ResultadoPrueba> resultadoPruebaOpt = ResultadoPruebaService.findByEstudianteId(id);
        if (resultadoPruebaOpt.isPresent()) {
            ResultadoPrueba resultadoPrueba = resultadoPruebaOpt.get();
            return new ResponseEntity<>(resultadoPrueba, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontraron resultados para el estudiante con ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}


