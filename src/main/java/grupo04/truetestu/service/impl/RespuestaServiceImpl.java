package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.mapper.RespuestaMapper;
import grupo04.truetestu.model.entity.Respuesta;
import grupo04.truetestu.repository.RespuestaRepository;
import grupo04.truetestu.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    private final RespuestaMapper respuestaMapper = RespuestaMapper.INSTANCE;

    @Override
    public List<RespuestaDTO> obtenerRespuestas() {
        return respuestaRepository.findAll().stream()
                .map(respuestaMapper::respuestaToRespuestaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RespuestaDTO crearRespuesta(RespuestaDTO respuestaDTO) {
        Respuesta respuesta = respuestaMapper.respuestaDTOToRespuesta(respuestaDTO);
        respuesta = respuestaRepository.save(respuesta);
        return respuestaMapper.respuestaToRespuestaDTO(respuesta);
    }
}
