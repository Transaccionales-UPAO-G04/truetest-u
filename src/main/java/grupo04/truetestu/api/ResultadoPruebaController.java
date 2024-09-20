package grupo04.truetestu.controller;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.service.ResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> feature/ResultadoPrueba

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/resultados")
public class ResultadoPruebaController {

    private final ResultadoPruebaService resultadoPruebaService;

<<<<<<< HEAD
    // Crear un nuevo ResultadoPrueba
=======
>>>>>>> feature/ResultadoPrueba
    @PostMapping
    public ResponseEntity<ResultadoPrueba> create(@RequestBody ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba createdResultado = resultadoPruebaService.create(resultadoPrueba);
        return new ResponseEntity<>(createdResultado, HttpStatus.CREATED);
    }

<<<<<<< HEAD
    // Buscar un ResultadoPrueba por su ID
=======
>>>>>>> feature/ResultadoPrueba
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> findById(@PathVariable Integer id) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaService.findByID(id);
        return ResponseEntity.ok(resultadoPrueba);
    }

<<<<<<< HEAD
    // Obtener todos los ResultadosPrueba
=======
>>>>>>> feature/ResultadoPrueba
    @GetMapping
    public ResponseEntity<List<ResultadoPrueba>> getAll() {
        List<ResultadoPrueba> resultados = resultadoPruebaService.getAll();
        return ResponseEntity.ok(resultados);
    }

<<<<<<< HEAD
    // Actualizar un ResultadoPrueba por su ID
=======
>>>>>>> feature/ResultadoPrueba
    @PutMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> update(@PathVariable Integer id, @RequestBody ResultadoPrueba resultadoPrueba) {
        ResultadoPrueba updatedResultado = resultadoPruebaService.update(id, resultadoPrueba);
        return ResponseEntity.ok(updatedResultado);
    }

<<<<<<< HEAD
    // Eliminar un ResultadoPrueba por su ID
=======
>>>>>>> feature/ResultadoPrueba
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        resultadoPruebaService.delete(id);
        return ResponseEntity.noContent().build();
    }
<<<<<<< HEAD

    // Obtener ResultadosPrueba por el ID del estudiante
    @GetMapping("/estudiante/{id}")
    public ResponseEntity<?> getResultadoPruebaByEstudianteId(@PathVariable("id") int id) {
        Optional<ResultadoPrueba> resultadoPruebaOpt = resultadoPruebaService.findByEstudianteId(id);
        if (resultadoPruebaOpt.isPresent()) {
            ResultadoPrueba resultadoPrueba = resultadoPruebaOpt.get();
            return new ResponseEntity<>(resultadoPrueba, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontraron resultados para el estudiante con ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
=======
>>>>>>> feature/ResultadoPrueba
}

