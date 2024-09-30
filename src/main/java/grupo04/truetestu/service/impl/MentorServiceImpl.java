package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;

    @Override
    public List<Mentor> findAll() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentor findById(int id) {
        return mentorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentor no encontrado"));
    }

    @Override
    public List<Mentor> findByEspecialidad(String especialidad) {
        return mentorRepository.findByEspecialidad(especialidad);
    }

    @Override
    @Transactional
    public Mentor createMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    @Transactional
    public Mentor updateMentor(int id, Mentor mentorDetails) {
        Mentor mentor = findById(id);
        mentor.setNombreMentor(mentorDetails.getNombreMentor());
        mentor.setExperiencia(mentorDetails.getExperiencia());
        mentor.setEspecialidad(mentorDetails.getEspecialidad());
        mentor.setNroAsesorias(mentorDetails.getNroAsesorias());
        return mentorRepository.save(mentor);
    }

    @Override
    @Transactional
    public void deleteMentor(int id) {
        Mentor mentor = findById(id);
        mentorRepository.delete(mentor);
    }

    // Implementación para recomendar mentores por especialidad y experiencia
    @Override
    public List<Mentor> recomendarMentoresPorEspecialidad(String especialidad, int minExperiencia, int maxExperiencia) {
        // Busca mentores con la misma especialidad y experiencia dentro de un rango
        return mentorRepository.findByEspecialidadAndExperienciaBetween(especialidad, minExperiencia, maxExperiencia);
    }
}
