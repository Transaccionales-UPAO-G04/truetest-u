package grupo04.truetestu.api;


import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/profile")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ESTUDIANTE', 'MENTOR')")
public class UserProfileController {

    private final UsuarioService usuarioService;

    //Actualizar el perfil del usuario
    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDTO> updateProfile(@PathVariable int id, @Valid @RequestBody UserProfileDTO userProfileDTO) {
        UserProfileDTO updateUserProfile = usuarioService.updateUsuariosProfile(id, userProfileDTO);
        return new ResponseEntity<>(updateUserProfile, HttpStatus.OK);
    }

    //Obtener perfil de usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getProfile(@PathVariable int id) {
        UserProfileDTO userProfile = usuarioService.getUsuarioProfileById(id);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }
    @PutMapping("/{id}/foto")
    public ResponseEntity<UserProfileDTO> updateProfilePhoto(@PathVariable int id, @RequestBody UserProfileDTO userProfileDTO) {
        // Aquí se actualiza únicamente la foto de perfil
        UserProfileDTO updatedProfile = usuarioService.updateUsuariosProfile(id, userProfileDTO);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }


}
