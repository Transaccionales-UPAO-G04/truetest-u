package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Recurso;
import grupo04.truetestu.repository.RecursoRepository;
import grupo04.truetestu.service.RecursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RecursoServiceImpl implements RecursoService {
    private final RecursoRepository recursoRepository;

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
    public List<Recurso> obtenerRecursosGratisPorMentor(int idMentor) {
        return recursoRepository.findByEsPremiumFalseAndMentor_IdMentor(idMentor);
    }

    @Override
    public List<Recurso> obtenerRecursosPremiumPorMentor(int idMentor) {
        return recursoRepository.findByEsPremiumTrueAndMentor_IdMentor(idMentor);
    }
}
