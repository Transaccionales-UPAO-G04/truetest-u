package grupo04.truetestu.api;


import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PutMapping("/{id}/foto")
    public ResponseEntity<String> updateProfilePhoto(@PathVariable int id, @RequestBody Map<String, String> body) {
        String fotoPerfil = body.get("fotoPerfil");

        if (fotoPerfil == null || fotoPerfil.isEmpty()) {
            return ResponseEntity.badRequest().body("La foto de perfil no puede estar vacía.");
        }

        usuarioService.actualizarFotoPerfil(id, fotoPerfil);
        return ResponseEntity.ok("Foto de perfil actualizada con éxito.");
    }

    //Obtener perfil de usuario por id
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getProfile(@PathVariable int id) {
        UserProfileDTO userProfile = usuarioService.getUsuarioProfileById(id);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);
    }

}
