package grupo04.truetestu.api;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.service.ResultadoPruebaService;
import io.swagger.v3.oas.annotations.Operation; // Importa la anotación
import io.swagger.v3.oas.annotations.Parameter; // Importa la anotación
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultados")
@RequiredArgsConstructor
public class ResultadoPruebaController {

    private final ResultadoPruebaService ResultadoPruebaService;

    // Crear un nuevo ResultadoPrueba
    @Operation(summary = "Crear un nuevo ResultadoPrueba",
            description = "Crea un nuevo resultado de prueba con los datos proporcionados.")
    @PostMapping
    public ResponseEntity<ResultadoPruebaDTO> create(@RequestBody ResultadoPruebaDTO resultadoPruebaDTO) {
        ResultadoPruebaDTO createdResultadoDTO = ResultadoPruebaService.create(resultadoPruebaDTO);
        return new ResponseEntity<>(createdResultadoDTO, HttpStatus.CREATED);
    }

    // Buscar un ResultadoPrueba por su ID
    @Operation(summary = "Buscar un ResultadoPrueba por su ID",
            description = "Devuelve el resultado de prueba correspondiente al ID proporcionado.")
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPruebaDTO> findById(@PathVariable Integer id) {
        ResultadoPruebaDTO resultadoPruebaDTO = ResultadoPruebaService.findByID(id);
        return ResponseEntity.ok(resultadoPruebaDTO);  // Devuelve el DTO en lugar de la entidad
    }

    // Obtener todos los ResultadosPrueba
    @Operation(summary = "Obtener todos los ResultadosPrueba",
            description = "Devuelve una lista de todos los resultados de prueba.")
    @GetMapping
    public ResponseEntity<List<ResultadoPruebaDTO>> getAll() {
        List<ResultadoPruebaDTO> resultados = ResultadoPruebaService.getAll();
        return ResponseEntity.ok(resultados);
    }

    // Actualizar un ResultadoPrueba por su ID
    @Operation(summary = "Actualizar un ResultadoPrueba por su ID",
            description = "Actualiza el resultado de prueba correspondiente al ID proporcionado.")
    @PutMapping("/{id}")
    public ResponseEntity<ResultadoPruebaDTO> update(@PathVariable Integer id, @RequestBody ResultadoPruebaDTO resultadoPruebaDTO) {
        ResultadoPruebaDTO updatedResultado = ResultadoPruebaService.update(id, resultadoPruebaDTO);
        return ResponseEntity.ok(updatedResultado);
    }

    // Eliminar un ResultadoPrueba por su ID
    @Operation(summary = "Eliminar un ResultadoPrueba por su ID",
            description = "Elimina el resultado de prueba correspondiente al ID proporcionado.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ResultadoPruebaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener ResultadosPrueba por el ID del estudiante
    @Operation(summary = "Obtener ResultadosPrueba por el ID del estudiante",
            description = "Devuelve el resultado de prueba correspondiente al ID del estudiante.")
    @GetMapping("/estudiante/{id}")
    public ResponseEntity<?> getResultadoPruebaByEstudianteId(@PathVariable("id") int id) {
        try {
            ResultadoPruebaDTO resultadoPrueba = ResultadoPruebaService.findByID(id);
            return ResponseEntity.ok(resultadoPrueba);
        } catch (Exception e) {
            return new ResponseEntity<>("No se encontraron resultados para el estudiante con ID: " + id, HttpStatus.NOT_FOUND);
        }
    }
}


