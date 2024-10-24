package grupo04.truetestu.service.impl;
import java.util.List;
import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.repository.HorarioRepository;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.Infra.exception.ResourceNotFoundException;
import grupo04.truetestu.repository.ReseñaRepository;
import grupo04.truetestu.repository.SesionRepository;
import grupo04.truetestu.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MentorServiceImpl implements MentorService {
    private final HorarioRepository horarioRepository;
    private final ReseñaRepository reseñaRepository;
    private final SesionRepository sesionRepository;
    private final MentorRepository mentorRepository;

    @Override
    public List<Mentor> findAll() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentor findById(int id) {
        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor no encontrado"));
        int cantidadReseñas = mentor.getReseñas().size();
        return mentor;
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
        horarioRepository.deleteById(id);
        sesionRepository.deleteById(id);
        mentorRepository.deleteById(id);
    }
}