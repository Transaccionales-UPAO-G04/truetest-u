package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Mentor;
import grupo04.truetestu.model.entity.Recurso;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.repository.MentorRepository;
import grupo04.truetestu.repository.RecursoRepository;
import grupo04.truetestu.service.RecursoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RecursoServiceImpl implements RecursoService {
    private final RecursoRepository recursoRepository;
    private final EstudianteRepository estudianteRepository;
    private final MentorRepository mentorRepository;

    @Override
    public List<Recurso> obtenerTodos() {
        return recursoRepository.findAll();
    }

    @Override
    public Optional<Recurso> obtenerPorId(int id) {
        return recursoRepository.findById(id);
    }

    @Override
    public Recurso guardar(Recurso recurso) {

        if (recurso.getMentor() == null || recurso.getMentor().getIdMentor() == 0) {
            throw new EntityNotFoundException("El mentor no puede ser nulo y debe tener un ID válido.");
        }

        // Verifica si el mentor existe
        Mentor mentor = mentorRepository.findById(recurso.getMentor().getIdMentor())
                .orElseThrow(() -> new EntityNotFoundException("Mentor no encontrado"));

        recurso.setMentor(mentor);


        if (recurso.getEstudiante() != null && recurso.getEstudiante().getIdEstudiante() != 0) {
            Estudiante estudiante = estudianteRepository.findById(recurso.getEstudiante().getIdEstudiante())
                    .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado"));
            recurso.setEstudiante(estudiante);
        }

        return recursoRepository.save(recurso);
    }

    @Override
    public void eliminar(int id) {
        recursoRepository.deleteById(id);
    }

    @Override
    public List<Recurso> obtenerRecursosGratis() {
        return recursoRepository.findByEsPremiumFalse();
    }

    @Override
    public List<Recurso> obtenerRecursosPremium() {
        return recursoRepository.findByEsPremiumTrue();
    }

    @Override
    public List<Recurso> obtenerRecursosGratisPorEspecialidad(String especialidad) {
        return recursoRepository.findByEsPremiumAndMentor_Especialidad(false, especialidad);
    }

    @Override
    public List<Recurso> obtenerRecursosPremiumPorEspecialidad(String especialidad) {
        return recursoRepository.findByEsPremiumAndMentor_Especialidad(true, especialidad);
    }


    @Override
    public Recurso cambiarEstadoFavorito(int recursoId) {
        Recurso recurso = recursoRepository.findById(recursoId)
                .orElseThrow(() -> new EntityNotFoundException("Recurso no encontrado"));

        recurso.setEsFavorito(!recurso.isEsFavorito());
        return recursoRepository.save(recurso);
    }
}
