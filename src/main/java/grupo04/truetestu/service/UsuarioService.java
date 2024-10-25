package grupo04.truetestu.service;

import grupo04.truetestu.dto.UserProfileDTO;

public interface UsuarioService {

    UserProfileDTO registrarMentor(UserProfileDTO registrationDTO);


    UserProfileDTO registrarEstudiante(UserProfileDTO registrationDTO);

    UserProfileDTO updateUsuario(int id, UserProfileDTO updateDTO);


    UserProfileDTO getUsuarioProfileById(int id);




}
