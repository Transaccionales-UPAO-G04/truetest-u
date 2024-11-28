package grupo04.truetestu.service;

import grupo04.truetestu.dto.HorarioDTO;

import java.util.List;

public interface HorarioService {
    HorarioDTO createHorario(HorarioDTO horarioDTO, int mentorId);
    HorarioDTO updateHorario(int idHorario, HorarioDTO horarioDTO, int mentorId);
    void deleteHorario(int idHorario, int mentorId);
    List<HorarioDTO> getHorariosByMentorId(int mentorId);
    HorarioDTO registerStudentToHorario(int idHorario, int estudianteId);  // Método para que el estudiante se registre
    void unregisterStudentFromHorario(int idHorario, int estudianteId, int mentorId);  // Método para quitar el registro
}
