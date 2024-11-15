package grupo04.truetestu.service.impl;
import java.util.List;

import grupo04.truetestu.dto.MentorDetailsDTO;
import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.mapper.MentorMapper;
import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.repository.HorarioRepository;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.repository.UsuarioRepository;
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
    private final UsuarioRepository usuarioRespository;

    @Override
    public List<MentorDetailsDTO> findAll() {
        List<Mentor> mentor = mentorRepository.findAll();
        return mentor.stream()
                .map(mentorMapper::toDTO)
                .toList();
    }

    @Override
    public MentorDetailsDTO findById(int id) {
        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor no encontrado"));
        int cantidadReseñas = mentor.getReseñas().size();
        return mentorMapper.toDTO(mentor);
    }


    @Override
    public List<MentorDetailsDTO> findByEspecialidad(String especialidad) {
         List <Mentor> mentor = mentorRepository.findByEspecialidad(especialidad);
         return mentor.stream()
                 .map(mentorMapper::toDTO)
                 .toList();
    }
    @Transactional
    @Override
    public MentorDetailsDTO createMentor (MentorDetailsDTO mentorDetailsDTO) {
        Mentor mentor = mentorMapper.toEntity(mentorDetailsDTO);
        mentor = mentorRepository.save(mentor);
        return mentorMapper.toDTO(mentor);
    }

    @Override
    @Transactional
    public MentorDetailsDTO updateMentor(int id, MentorDetailsDTO mentorDetails) {
        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor no encontrado"));
        //verificar si ya existe el mentor con correo

        mentor.setExperiencia(mentorDetails.getExperiencia());
        mentor.setEspecialidad(mentorDetails.getEspecialidad());
        mentor.setNombre(mentorDetails.getNombre());
        mentor.setLinkRecurso(mentorDetails.getLinkRecurso());
        mentor.setLinkRecursoPremium(mentorDetails.getLinkRecursoPremium());
        Mentor updateMentor = mentorRepository.save(mentor);
        return mentorMapper.toDTO(updateMentor);
    }

    @Override
    @Transactional
    public void deleteMentor(int id) {
        //bUSCAR MENTOR DE ID
        Mentor mentor = mentorRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Mentor no encontrado"));

        horarioRepository.deleteById(id);
        mentorRepository.deleteById(id);
    }
}