package grupo04.truetestu.service;

import grupo04.truetestu.dto.HorarioDTO;

import java.util.List;

public interface HorarioService {
    HorarioDTO createHorario(HorarioDTO horarioDTO, int mentorId);
    HorarioDTO updateHorario(int idHorario, HorarioDTO horarioDTO, int mentorId);
    void deleteHorario(int idHorario, int mentorId);
    List<HorarioDTO> getHorariosByMentorId(int mentorId);
}
