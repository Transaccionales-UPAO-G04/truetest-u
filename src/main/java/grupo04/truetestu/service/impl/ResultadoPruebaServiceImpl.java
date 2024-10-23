package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.mapper.ResultadoPruebaMapper;
import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.repository.ResultadoPruebaRepository;
import grupo04.truetestu.service.ResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResultadoPruebaServiceImpl implements ResultadoPruebaService {

    private final ResultadoPruebaRepository resultadoPruebaRepository;
    private final ResultadoPruebaMapper resultadoPruebaMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ResultadoPruebaDTO> getAll() {
        List<ResultadoPrueba> resultados = resultadoPruebaRepository.findAll();
        return resultados.stream()
                .map(resultadoPruebaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ResultadoPruebaDTO> paginate(Pageable pageable) {
        Page<ResultadoPrueba> resultadosPage = resultadoPruebaRepository.findAll(pageable);
        return resultadosPage.map(resultadoPruebaMapper::toDTO);
    }

    @Transactional(readOnly = true)
    @Override
    public ResultadoPruebaDTO findByEstudianteId(int id) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaRepository.findByEstudianteId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado de prueba para el estudiante con ID " + id + " no encontrado"));
        return resultadoPruebaMapper.toDTO(resultadoPrueba);
    }

    @Transactional
    @Override
    public ResultadoPruebaDTO create(ResultadoPruebaDTO resultadoPruebaDTO) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaMapper.toEntity(resultadoPruebaDTO);
        ResultadoPrueba savedResultadoPrueba = resultadoPruebaRepository.save(resultadoPrueba);
        return resultadoPruebaMapper.toDTO(savedResultadoPrueba);
    }

    @Transactional(readOnly = true)
    @Override
    public ResultadoPruebaDTO findByID(Integer id) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado de prueba no encontrado para el ID: " + id));
        return resultadoPruebaMapper.toDTO(resultadoPrueba);
    }

    @Transactional
    @Override
    public ResultadoPruebaDTO update(Integer id, ResultadoPruebaDTO updatedResultadoPruebaDTO) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResultadoPrueba con ID " + id + " no encontrado"));
        resultadoPrueba.setPuntaje(updatedResultadoPruebaDTO.getPuntaje());
        resultadoPrueba.setRecomendacion(updatedResultadoPruebaDTO.getRecomendacion());
        ResultadoPrueba updatedResultadoPrueba = resultadoPruebaRepository.save(resultadoPrueba);
        return resultadoPruebaMapper.toDTO(updatedResultadoPrueba);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResultadoPrueba con ID " + id + " no encontrado"));
        resultadoPruebaRepository.delete(resultadoPrueba);
    }
}

