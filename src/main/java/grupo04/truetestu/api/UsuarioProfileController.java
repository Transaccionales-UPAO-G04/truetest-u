package grupo04.truetestu.api;


import grupo04.truetestu.dto.UsuarioProfileDTO;
import grupo04.truetestu.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/profile")
@RequiredArgsConstructor
public class UsuarioProfileController {

    private final UsuarioService usuarioService;

    //Actualizar el perfil del usuario
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioProfileDTO> updateUsuarioProfile(@PathVariable int id, @RequestBody UsuarioProfileDTO usuarioProfileDTO) {
        UsuarioProfileDTO updateUsuarioProfile = usuarioService.updateUsuario(id, usuarioProfileDTO);
        return new ResponseEntity<>(updateUsuarioProfile, HttpStatus.OK);
    }

    //Obtener perfil de usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioProfileDTO> getUsuarioProfile(@PathVariable int id) {
        UsuarioProfileDTO usuarioProfile = usuarioService.getUsuarioProfileById(id);
        return new ResponseEntity<>(usuarioProfile, HttpStatus.OK);
    }
}
