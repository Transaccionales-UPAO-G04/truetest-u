package grupo04.truetestu.service;

import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.dto.UserRegistrationDTO;

public interface UsuarioService {

    UserProfileDTO registrarMentor(UserRegistrationDTO registrationDTO);

    UserProfileDTO registrarEstudiante(UserRegistrationDTO registrationDTO);

    UserProfileDTO updateUsuario(int id, UserProfileDTO updateDTO);


    UserProfileDTO getUsuarioProfileById(int id);




}
