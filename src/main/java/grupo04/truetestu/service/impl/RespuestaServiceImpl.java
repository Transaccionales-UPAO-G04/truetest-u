package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.model.entity.Respuesta;
import grupo04.truetestu.repository.RespuestaRepository;
import grupo04.truetestu.service.RespuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaRepository respuestaRepository;

    @Transactional
    @Override
    public RespuestaDTO create(RespuestaDTO respuestaDTO) {
        Respuesta respuesta = convertToEntity(respuestaDTO);
        Respuesta nuevaRespuesta = respuestaRepository.save(respuesta);
        return convertToDTO(nuevaRespuesta);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RespuestaDTO> getAll() {
        return respuestaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<RespuestaDTO> findByID(Integer id) {
        return respuestaRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Transactional
    @Override
    public Optional<RespuestaDTO> update(Integer id, RespuestaDTO respuestaDTO) {
        return respuestaRepository.findById(id)
                .map(existing -> {
                    existing.setTexto(respuestaDTO.getTexto());
                    existing.setEsCorrecta(respuestaDTO.isEsCorrecta());
                    Respuesta updatedRespuesta = respuestaRepository.save(existing);
                    return convertToDTO(updatedRespuesta);
                });
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        respuestaRepository.deleteById(id);
    }

    private RespuestaDTO convertToDTO(Respuesta respuesta) {
        RespuestaDTO dto = new RespuestaDTO();
        dto.setId(respuesta.getId());
        dto.setTexto(respuesta.getTexto());
        dto.setEsCorrecta(respuesta.isEsCorrecta());
        return dto;
    }

    private Respuesta convertToEntity(RespuestaDTO dto) {
        Respuesta respuesta = new Respuesta();
        respuesta.setTexto(dto.getTexto());
        respuesta.setEsCorrecta(dto.isEsCorrecta());
        return respuesta;
    }
}
