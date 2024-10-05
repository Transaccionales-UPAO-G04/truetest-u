package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Sesion;
import grupo04.truetestu.service.SesionService;
import grupo04.truetestu.service.impl.EstudianteServiceImpl;
import io.swagger.v3.oas.annotations.Operation; // Importa la anotación
import io.swagger.v3.oas.annotations.Parameter; // Importa la anotación
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sesiones/")
public class SesionController {

    @Autowired
    private SesionService sesionService;
    @Autowired
    private EstudianteServiceImpl estudianteServiceImpl;

    @Operation(summary = "Guardar una nueva sesión",
            description = "Crea una nueva sesión asociada a un estudiante.")
    @PostMapping("/guardarSesion")
    public ResponseEntity<Sesion> guardarSesion(@RequestBody Sesion sesion, @RequestParam int idEstudiante) {
        Estudiante estudiante = estudianteServiceImpl.findById(idEstudiante);  // Obtén el estudiante
        sesion.setEstudiante(estudiante);  // Asigna el estudiante a la sesión
        Sesion nuevaSesion = sesionService.guardarSesion(sesion);
        return new ResponseEntity<>(nuevaSesion, HttpStatus.CREATED);
    }


}