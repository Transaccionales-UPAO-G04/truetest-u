package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.HorarioDTO;
import grupo04.truetestu.mapper.HorarioMapper;
import grupo04.truetestu.repository.EstudianteRepository;
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
    private final EstudianteRepository estudianteRepository;

    public HorarioServiceImpl(HorarioRepository horarioRepository, MentorRepository mentorRepository, EstudianteRepository estudianteRepository,HorarioMapper horarioMapper) {
        this.horarioRepository = horarioRepository;
        this.mentorRepository = mentorRepository;
        this.horarioMapper = horarioMapper;
        this.estudianteRepository = estudianteRepository;
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

    @Override
    @Transactional
    public HorarioDTO registerStudentToHorario(int idHorario, int estudianteId) {
        var horario = horarioRepository.findById(idHorario)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado"));

        var estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado"));

        // Verificar si el horario ya tiene un estudiante registrado
        if (horario.getEstudiante() != null) {
            throw new IllegalArgumentException("Este horario ya tiene un estudiante registrado");
        }

        horario.setEstudiante(estudiante);
        return horarioMapper.toDTO(horarioRepository.save(horario));
    }

    public void unregisterStudentFromHorario(int idHorario, int estudianteId, int mentorId) {
        var horario = horarioRepository.findById(idHorario)
                .orElseThrow(() -> new EntityNotFoundException("Horario no encontrado"));

        // Si la persona que hace la solicitud es el mentor
        if (mentorId != -1 && horario.getMentor().getIdMentor() == mentorId) {
            // El mentor puede quitar cualquier estudiante
            horario.setEstudiante(null);
            horarioRepository.save(horario);
        } else if (estudianteId != -1 && horario.getEstudiante() != null && horario.getEstudiante().getIdEstudiante() == estudianteId) {
            // El estudiante puede quitarse a sí mismo
            horario.setEstudiante(null);
            horarioRepository.save(horario);
        } else {
            throw new IllegalArgumentException("No autorizado para quitar el registro");
        }
    }

}