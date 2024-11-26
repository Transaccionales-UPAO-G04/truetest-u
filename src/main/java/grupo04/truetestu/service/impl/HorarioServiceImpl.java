package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.HorarioDTO;
import grupo04.truetestu.mapper.HorarioMapper;
import grupo04.truetestu.repository.HorarioRepository;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.service.HorarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository horarioRepository;
    private final MentorRepository mentorRepository;
    private final HorarioMapper horarioMapper;

    public HorarioServiceImpl(HorarioRepository horarioRepository, MentorRepository mentorRepository, HorarioMapper horarioMapper) {
        this.horarioRepository = horarioRepository;
        this.mentorRepository = mentorRepository;
        this.horarioMapper = horarioMapper;
    }

    @Override
    @Transactional
    public HorarioDTO createHorario(HorarioDTO horarioDTO, int mentorId) {
        var mentor = mentorRepository.findById(mentorId)
                .orElseThrow(() -> new EntityNotFoundException("Mentor no encontrado"));
        var horario = horarioMapper.toEntity(horarioDTO);
        horario.setMentor(mentor);
        return horarioMapper.toDTO(horarioRepository.save(horario));
    }

    @Override
    @Transactional
    public HorarioDTO updateHorario(int idHorario, HorarioDTO horarioDTO, int mentorId) {
        var horario = horarioRepository.findById(idHorario)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado"));

        if (horario.getMentor().getIdMentor() != mentorId) {
            throw new IllegalArgumentException("No autorizado para modificar este horario");
        }

        horario.setFecha(horarioDTO.getFecha());
        horario.setHoraSesion(horarioDTO.getHoraSesion());
        horario.setLinkSesionPublica(horarioDTO.getLinkSesionPublica());

        return horarioMapper.toDTO(horarioRepository.save(horario));
    }

    @Override
    @Transactional
    public void deleteHorario(int idHorario, int mentorId) {
        var horario = horarioRepository.findById(idHorario)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado"));

        if (horario.getMentor().getIdMentor() != mentorId) {
            throw new IllegalArgumentException("No autorizado para eliminar este horario");
        }

        horarioRepository.delete(horario);
    }

    @Override
    public List<HorarioDTO> getHorariosByMentorId(int mentorId) {
        return horarioRepository.findAll().stream()
                .filter(horario -> horario.getMentor().getIdMentor() == mentorId)
                .map(horarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}