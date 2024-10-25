package grupo04.truetestu.api;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.service.EstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final EstudianteService estudianteService;

    @Operation(summary = "Registrar un nuevo estudiante", description = "Crea un nuevo estudiante en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estudiante registrado con éxito"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public ResponseEntity <EstudianteDTO> registrar(@Valid @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO createdEstudiante = estudianteService.registerEstudiante(estudianteDTO);
        return new ResponseEntity<>(createdEstudiante, HttpStatus.CREATED);
    }

    @Operation(summary = "Iniciar sesión como estudiante", description = "Autentica a un estudiante en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso"),
            @ApiResponse(responseCode = "401", description = "Credenciales no válidas")
    })
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Estudiante estudiante) {
        try {
            Estudiante estudianteExistente = estudianteService.sesionEstudiante(estudiante);
            return ResponseEntity.ok("INICIO DE SESION EXITOSO");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


}