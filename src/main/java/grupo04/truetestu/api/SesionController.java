package grupo04.truetestu.api;

import grupo04.truetestu.dto.SesionDTO;
import grupo04.truetestu.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    // Crear una nueva sesión
    @PostMapping
    public ResponseEntity<SesionDTO> create(@RequestBody SesionDTO sesionDTO) {
        SesionDTO createdSesion = sesionService.create(sesionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSesion);
    }

    // Actualizar el link de la sesión privada
    @PutMapping("/{id}/sesionLink")
    public ResponseEntity<SesionDTO> updateByLinkSesionPrivada(@PathVariable int id, @RequestBody SesionDTO updateSesionDTO) {
        SesionDTO updatedSesion = sesionService.updateByLinkSesionPrivada(id, updateSesionDTO);
        return ResponseEntity.ok(updatedSesion);
    }

    // Listar todas las sesiones
    @GetMapping
    public ResponseEntity<List<SesionDTO>> findAll() {
        List<SesionDTO> sesiones = sesionService.findAll();
        return ResponseEntity.ok(sesiones);
    }

    // Obtener una sesión por ID
    @GetMapping("/{id}")
    public ResponseEntity<SesionDTO> findById(@PathVariable int id) {
        SesionDTO sesion = sesionService.findById(id);
        return ResponseEntity.ok(sesion);
    }

    // Eliminar una sesión por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        sesionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}