package grupo04.truetestu.service.impl;
import grupo04.truetestu.dto.ReseñaDTO;
import grupo04.truetestu.mapper.ReseñaMapper;
import grupo04.truetestu.model.entity.Reseña;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.repository.ReseñaRepository;
import grupo04.truetestu.service.ReseñaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReseñaServiceImpl implements ReseñaService {

    private final ReseñaRepository reseñaRepository;
    private final ReseñaMapper reseñaMapper;
    private final MentorRepository mentorRepository;
    private final EstudianteRepository estudianteRepository;

    // Método para obtener todas las reseñas
    @Override
    public List<ReseñaDTO> findAll() {
        List<Reseña> reseñas = reseñaRepository.findAll();
        return reseñas.stream()
                .map(reseñaMapper::toDTO)
                .toList();
    }

    // Método para encontrar una reseña por ID
    @Override
    public ReseñaDTO findById(int id) {
        Reseña reseña = reseñaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada con id: " + id));
        return reseñaMapper.toDTO(reseña);
    }

    // Método para crear una nueva reseña
    @Transactional
    @Override
    public ReseñaDTO createReseña(int idMentor, int idEstudiante, ReseñaDTO reseñaDTO) {
        var mentor = mentorRepository.findById(idMentor).orElseThrow(() -> new RuntimeException("Mentor no encontrado"));
        var estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        var reseña = reseñaMapper.toEntity(reseñaDTO);
        reseña.setMentor(mentor);
        reseña.setEstudiante(estudiante);
        return reseñaMapper.toDTO(reseñaRepository.save(reseña));
    }

    //listar reseñas segun el mentor
    @Override
    public List<ReseñaDTO> findByMentorId(int idMentor) {
       List<Reseña> reseñaDTO = reseñaRepository.findAllByMentor_IdMentor(idMentor);
        return reseñaDTO.stream()
                .map(reseñaMapper::toDTO)
                .toList();
    }

    // Método para eliminar una reseña por ID
    @Override
    @Transactional
    public void delete(int id) {
        // Buscar la reseña por ID antes de eliminarla
        Reseña reseña = reseñaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada con id: " + id));

        // Eliminar la reseña
        reseñaRepository.deleteById(id);
    }

}
