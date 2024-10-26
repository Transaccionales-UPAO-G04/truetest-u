package grupo04.truetestu.api;

import grupo04.truetestu.dto.*;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;


    //ednpoint para registrar estudiantes
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid  @RequestBody LoginDTO loginDTO) {
        AuthResponseDTO authResponse = usuarioService.login(loginDTO);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/register/estudiante")
    public ResponseEntity <UserProfileDTO> registerEstudiante(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        UserProfileDTO userProfileDTO = usuarioService.registrarEstudiante(userRegistrationDTO);
        return new ResponseEntity<>(userProfileDTO, HttpStatus.CREATED);
    }

    @PostMapping("/register/mentor")
    public ResponseEntity <UserProfileDTO> registerMentor(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        UserProfileDTO userProfileDTO = usuarioService.registrarMentor(userRegistrationDTO);
        return new ResponseEntity<>(userProfileDTO, HttpStatus.CREATED);
    }



}