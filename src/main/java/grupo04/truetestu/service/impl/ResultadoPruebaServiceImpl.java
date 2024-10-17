package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.mapper.ResultadoPruebaMapper;
import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.repository.ResultadoPruebaRepository;
import grupo04.truetestu.service.ResultadoPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultadoPruebaServiceImpl implements ResultadoPruebaService {

    @Autowired
    private ResultadoPruebaRepository resultadoPruebaRepository;

    private final ResultadoPruebaMapper mapper = ResultadoPruebaMapper.INSTANCE;

    @Override
    public List<ResultadoPruebaDTO> obtenerResultados() {
        return resultadoPruebaRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResultadoPruebaDTO crearResultadoPrueba(ResultadoPruebaDTO resultadoPruebaDTO) {
        ResultadoPrueba resultadoPrueba = mapper.toEntity(resultadoPruebaDTO);
        resultadoPrueba = resultadoPruebaRepository.save(resultadoPrueba);
        return mapper.toDto(resultadoPrueba);
    }
}

