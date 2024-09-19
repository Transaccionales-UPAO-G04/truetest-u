package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.service.EstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final EstudianteService estudianteService;
    @PostMapping("/register")
    public ResponseEntity<Estudiante> register(@RequestBody @Valid Estudiante estudiante) {
        Estudiante newEstudiante = estudianteService.registerEstudiante(estudiante);
        return new ResponseEntity<>(newEstudiante, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Estudiante estudiante) {
        try {
            Estudiante estudianteExistente = estudianteService.sesionEstudiante(estudiante);
            return ResponseEntity.ok("INICIO DE SESION EXITOSO");
        } catch (RuntimeException e) {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
