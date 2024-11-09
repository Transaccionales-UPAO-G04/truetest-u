package grupo04.truetestu.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sesiones/")
public class SesionController {/*

    @Autowired
    private SesionService sesionService;
    @Autowired
    private EstudianteServiceImpl estudianteServiceImpl;

    @PostMapping("/guardarSesion")
    public ResponseEntity<Sesion> guardarSesion(@RequestBody Sesion sesion, @RequestParam int idEstudiante) {
        Estudiante estudiante = estudianteServiceImpl.findById(idEstudiante);  // Obtén el estudiante
        sesion.setEstudiante(estudiante);  // Asigna el estudiante a la sesión
        Sesion nuevaSesion = sesionService.guardarSesion(sesion);
        return new ResponseEntity<>(nuevaSesion, HttpStatus.CREATED);
    }*/


}