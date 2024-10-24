package grupo04.truetestu.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import grupo04.truetestu.dto.MentorDTO;
import grupo04.truetestu.mapper.MentorMapper;
import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.repository.HorarioRepository;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.Infra.exception.ResourceNotFoundException;
import grupo04.truetestu.repository.ReseñaRepository;
import grupo04.truetestu.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MentorServiceImpl implements MentorService {
    private final HorarioRepository horarioRepository;
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;

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
        mentor.setExperiencia(mentorDetails.getExperiencia());
        mentor.setEspecialidad(mentorDetails.getEspecialidad());
        return mentorRepository.save(mentor);
    }

    @Override
    @Transactional
    public void deleteMentor(int id) {
        Mentor mentor = findById(id);
        horarioRepository.deleteById(id);
        mentorRepository.deleteById(id);
    }

    //Recursos
    @Transactional(readOnly = true)
    @Override
    public String getLinkRecursoByNombre(String nombre) {
        Mentor mentor = mentorRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor con nombre " + nombre + " no encontrado"));

        return mentor.getLinkRecurso();
    }

    @Transactional(readOnly = true)
    @Override
    public String getLinkRecursoPremiumByNombre(String nombre) {
        Mentor mentor = mentorRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor con nombre " + nombre + " no encontrado"));

        return mentor.getLinkRecursoPremium();
    }

    @Transactional(readOnly = true)
    @Override
    public MentorDTO getBothLinksByNombre(String nombre) {
        Mentor mentor = mentorRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor con nombre " + nombre + " no encontrado"));

        return mentorMapper.toDTO(mentor);
    }
}