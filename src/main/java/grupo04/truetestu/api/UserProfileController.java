package grupo04.truetestu.api;


import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UsuarioService usuarioService;

    //Actualizar el perfil del usuario
    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDTO> updateUserProfile(@PathVariable int id, @RequestBody UserProfileDTO userProfileDTO) {
        UserProfileDTO updateUserProfile = usuarioService.updateUsuario(id, userProfileDTO);
        return new ResponseEntity<>(updateUserProfile, HttpStatus.OK);
    }

    //Obtener perfil de usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable int id) {
        UserProfileDTO userProfile = usuarioService.getUsuarioProfileById(id);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }
}
