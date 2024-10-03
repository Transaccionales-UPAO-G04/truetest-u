package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")

public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return estudianteService.findAll();
    }

    // Endpoint para cambiar el plan de un estudiante
    @PatchMapping("/{id}/cambiar-plan")
    public ResponseEntity<?> cambiarPlan(@PathVariable int id, @RequestParam EstadoPlan nuevoPlan) {
        estudianteService.cambiarPlan(id, nuevoPlan);
        return ResponseEntity.ok().build();
    }

  //inhabilitar mentor
  @PatchMapping("/{id}/cambiar-estadoCuenta")
  public ResponseEntity<?> cambiarCuenta(@PathVariable int id, @RequestParam EstadoCuenta cambioEstadoCuenta) {
      estudianteService.cambiarCuenta(id, cambioEstadoCuenta);
      return ResponseEntity.ok().build();
  }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable int id,
                                                       @RequestBody Estudiante estudiante) {
        Estudiante updateEstudiante = estudianteService.update(id, estudiante);
        return new ResponseEntity<>(updateEstudiante, HttpStatus.OK);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        try {
            estudianteService.sendResetPasswordEmail(email);
            return ResponseEntity.ok("Se ha enviado un enlace para restablecer tu contraseña a tu correo electrónico.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
        try {
            estudianteService.updatePassword(email, newPassword);
            return ResponseEntity.ok("Tu contraseña ha sido actualizada con éxito.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}