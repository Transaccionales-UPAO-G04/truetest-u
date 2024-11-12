package grupo04.truetestu.service;
import grupo04.truetestu.dto.MentorDetailsDTO;
import grupo04.truetestu.model.entity.Mentor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MentorService {
    List<MentorDetailsDTO> findAll();
    MentorDetailsDTO findById(int id);
    List<MentorDetailsDTO> findByEspecialidad(String especialidad);
    @Transactional
    MentorDetailsDTO createMentor(MentorDetailsDTO mentorDetailsDTO);
    @Transactional
    MentorDetailsDTO updateMentor(int id, MentorDetailsDTO mentorDetailsDTO);
    void deleteMentor(int id);
}