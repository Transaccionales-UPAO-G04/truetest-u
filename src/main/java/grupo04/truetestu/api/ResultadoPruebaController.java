package grupo04.truetestu.api;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.service.ResultadoPruebaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultados")
@RequiredArgsConstructor
public class ResultadoPruebaController {

    private final ResultadoPruebaService resultadoPruebaService;

    // Obtener todos los ResultadosPrueba
    @Operation(summary = "Obtener todos los ResultadosPrueba",
            description = "Devuelve una lista de todos los resultados de prueba.")
    @GetMapping
    public ResponseEntity<List<ResultadoPruebaDTO>> obtenerResultados() {
        List<ResultadoPruebaDTO> resultados = resultadoPruebaService.obtenerResultados();
        return ResponseEntity.ok(resultados);
    }

    // Crear un nuevo ResultadoPrueba
    @Operation(summary = "Crear un nuevo ResultadoPrueba",
            description = "Crea un nuevo resultado de prueba con los datos proporcionados.")
    @PostMapping
    public ResponseEntity<ResultadoPruebaDTO> crearResultadoPrueba(@RequestBody ResultadoPruebaDTO resultadoPruebaDTO) {
        ResultadoPruebaDTO createdResultado = resultadoPruebaService.crearResultadoPrueba(resultadoPruebaDTO);
        return new ResponseEntity<>(createdResultado, HttpStatus.CREATED);
    }
}
