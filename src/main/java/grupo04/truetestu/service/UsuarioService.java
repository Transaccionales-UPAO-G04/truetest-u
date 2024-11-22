package grupo04.truetestu.service;

import grupo04.truetestu.dto.AuthResponseDTO;
import grupo04.truetestu.dto.LoginDTO;
import grupo04.truetestu.dto.UserProfileDTO;
import grupo04.truetestu.dto.UserRegistrationDTO;

public interface UsuarioService {

    UserProfileDTO registrarMentor(UserRegistrationDTO registrationDTO);

    UserProfileDTO registrarEstudiante(UserRegistrationDTO registrationDTO);

    AuthResponseDTO login(LoginDTO loginDTO);

    UserProfileDTO updateUsuariosProfile(int id, UserProfileDTO userProfileDTO);

    UserProfileDTO registrarAdmin(UserRegistrationDTO registrationDTO);

    UserProfileDTO getUsuarioProfileById(int id);




}
