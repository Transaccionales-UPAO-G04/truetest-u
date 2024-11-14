package grupo04.truetestu.service;

import grupo04.truetestu.dto.UsuarioProfileDTO;
import grupo04.truetestu.dto.UsuarioRegistrationDTO;

public interface UsuarioService {

    UsuarioProfileDTO registrarMentor(UsuarioRegistrationDTO registrationDTO);

    UsuarioProfileDTO registrarEstudiante(UsuarioRegistrationDTO registrationDTO);

    UsuarioProfileDTO updateUsuario(int id, UsuarioProfileDTO updateDTO);


    UsuarioProfileDTO getUsuarioProfileById(int id);




}
