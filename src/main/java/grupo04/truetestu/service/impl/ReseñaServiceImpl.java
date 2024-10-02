package grupo04.truetestu.service.impl;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Mentor;
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
    private final EstudianteRepository estudianteRepository;
    private final MentorRepository mentorRepository;

    // Método para obtener todas las reseñas
    @Override
    public List<Reseña> findAll() {
        return reseñaRepository.findAll();
    }

    // Método para encontrar una reseña por ID
    @Override
    public Reseña findById(int id) {
        return reseñaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada con id: " + id));
    }

    // Método para crear una nueva reseña
    @Override
    public Reseña createReseña(Reseña reseña) {
        // Verificar si el estudiante existe
        Estudiante estudiante = estudianteRepository.findById(reseña.getEstudiante().getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + reseña.getEstudiante().getIdEstudiante()));

        // Verificar si el mentor existe
        Mentor mentor = mentorRepository.findById(reseña.getMentor().getIdMentor())
                .orElseThrow(() -> new RuntimeException("Mentor no encontrado con id: " + reseña.getMentor().getIdMentor()));

        // Asignar el mentor y estudiante a la reseña
        reseña.setEstudiante(estudiante);
        reseña.setMentor(mentor);

        // Guardar la reseña en el repositorio
        return reseñaRepository.save(reseña);
    }

    // Método para actualizar una reseña existente
    @Override
    @Transactional
    public Reseña update(int id, Reseña reseñaDetails) {
        // Buscar la reseña existente por ID
        Reseña reseña = reseñaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada con id: " + id));

        // Actualizar los campos de la reseña
        reseña.setTexto(reseñaDetails.getTexto());
        reseña.setCalificacion(reseñaDetails.getCalificacion());

        // No permitimos cambiar el mentor o el estudiante después de la creación de la reseña

        // Guardar los cambios
        return reseñaRepository.save(reseña);
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
