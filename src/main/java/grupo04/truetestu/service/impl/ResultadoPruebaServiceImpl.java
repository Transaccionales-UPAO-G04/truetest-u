package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.repository.ResultadoPruebaRepository;
import grupo04.truetestu.service.ResultadoPruebaService;
import grupo04.truetestu.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResultadoPruebaServiceImpl implements ResultadoPruebaService {

    private final ResultadoPruebaRepository resultadoPruebaRepository;

    @Override
    public ResultadoPrueba create(ResultadoPrueba resultadoPrueba) {
        return resultadoPruebaRepository.save(resultadoPrueba);
    }

    @Override
    public ResultadoPrueba findByID(Integer id) {
        return resultadoPruebaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado de Prueba no encontrado"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ResultadoPrueba> getAll() {
        return resultadoPruebaRepository.findAll();
    }

    @Transactional
    @Override
    public ResultadoPrueba update(Integer id, ResultadoPrueba updatedResultadoPrueba) {
        ResultadoPrueba resultadoPrueba = findByID(id);
        resultadoPrueba.setPuntaje(updatedResultadoPrueba.getPuntaje());
        resultadoPrueba.setRecomendacion(updatedResultadoPrueba.getRecomendacion());
        resultadoPrueba.setPruebaVocacional(updatedResultadoPrueba.getPruebaVocacional());
        return resultadoPruebaRepository.save(resultadoPrueba);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        ResultadoPrueba resultadoPrueba = findByID(id);
        resultadoPruebaRepository.delete(resultadoPrueba);
    }
}
