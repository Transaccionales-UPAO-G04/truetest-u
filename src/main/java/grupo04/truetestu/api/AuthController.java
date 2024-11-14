package grupo04.truetestu.api;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.dto.UsuarioProfileDTO;
import grupo04.truetestu.dto.UsuarioRegistrationDTO;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService UsuarioService;


    //ednpoint para registrar estudiantes

    @PostMapping("/register/estudiante")
    public ResponseEntity <UsuarioProfileDTO> registerEstudiante(@Valid @RequestBody UsuarioRegistrationDTO usuarioRegistrationDTO) {
        UsuarioProfileDTO usuarioProfileDTO = UsuarioService.registrarEstudiante(usuarioRegistrationDTO);
        return new ResponseEntity<>(usuarioProfileDTO, HttpStatus.CREATED);
    }

    @PostMapping("/register/mentor")
    public ResponseEntity <UsuarioProfileDTO> registerMentor(@Valid @RequestBody UsuarioRegistrationDTO usuarioRegistrationDTO) {
        UsuarioProfileDTO usuarioProfileDTO = UsuarioService.registrarMentor(usuarioRegistrationDTO);
        return new ResponseEntity<>(usuarioProfileDTO, HttpStatus.CREATED);
    }



}