package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.repository.ResultadoPruebaRepository;
import grupo04.truetestu.service.ResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ResultadoPruebaServiceImpl implements ResultadoPruebaService {

    private final ResultadoPruebaRepository resultadoPruebaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResultadoPrueba> getAll() {
        return resultadoPruebaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ResultadoPrueba> paginate(Pageable pageable) {
        return resultadoPruebaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ResultadoPrueba> findByEstudianteId(int id) {
        return resultadoPruebaRepository.findByEstudianteId(id);
    }

    // Método para crear un nuevo ResultadoPrueba
    @Transactional
    @Override
    public ResultadoPrueba create(ResultadoPrueba resultadoPrueba) {
        return resultadoPruebaRepository.save(resultadoPrueba);
    }

    // Método para actualizar un ResultadoPrueba existente
    @Transactional
    @Override
    public ResultadoPrueba update(Integer id, ResultadoPrueba resultadoPrueba) {
        return resultadoPruebaRepository.findById(id)
                .map(existingResultado -> {
                    existingResultado.setPuntaje(resultadoPrueba.getPuntaje());
                    existingResultado.setRecomendacion(resultadoPrueba.getRecomendacion());
                    // Actualiza otros campos si es necesario
                    return resultadoPruebaRepository.save(existingResultado);
                })
                .orElseThrow(() -> new RuntimeException("ResultadoPrueba no encontrado con ID: " + id));
    }

    // Método para buscar un ResultadoPrueba por su ID
    @Transactional(readOnly = true)
    @Override
    public ResultadoPrueba findByID(Integer id) {
        return resultadoPruebaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ResultadoPrueba no encontrado con ID: " + id));
    }

    // Método para eliminar un ResultadoPrueba por su ID
    @Transactional
    @Override
    public void delete(Integer id) {
        resultadoPruebaRepository.deleteById(id);
    }
}
