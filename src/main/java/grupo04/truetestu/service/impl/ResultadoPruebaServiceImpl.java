package grupo04.truetestu.service.impl;

import grupo04.truetestu.exception.ResourceNotFoundException;
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

    @Transactional
    @Override
    public ResultadoPrueba create(ResultadoPrueba resultadoPrueba) {
        return resultadoPruebaRepository.save(resultadoPrueba);
    }

    @Transactional(readOnly = true)
    @Override
    public ResultadoPrueba findByID(Integer id) {
        return resultadoPruebaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado de Prueba no encontrado"));
    }

    @Transactional
    @Override
    public ResultadoPrueba update(Integer id, ResultadoPrueba updatedResultadoPrueba) {
        ResultadoPrueba resultadoPrueba = findByID(id);
        resultadoPrueba.setPuntaje(updatedResultadoPrueba.getPuntaje());
        resultadoPrueba.setRecomendacion(updatedResultadoPrueba.getRecomendacion());
        resultadoPrueba.setPruebaVocacional(updatedResultadoPrueba.getPruebaVocacional()); // Actualiza otros campos si es necesario
        return resultadoPruebaRepository.save(resultadoPrueba);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        ResultadoPrueba resultadoPrueba = findByID(id);
        resultadoPruebaRepository.delete(resultadoPrueba);
    }
}

