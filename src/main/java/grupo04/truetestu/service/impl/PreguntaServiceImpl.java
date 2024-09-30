package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.model.entity.Pregunta;
import grupo04.truetestu.repository.PreguntaRepository;
import grupo04.truetestu.service.PreguntaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    @Transactional
    @Override
    public PreguntaDTO create(PreguntaDTO preguntaDTO) {
        Pregunta pregunta = convertToEntity(preguntaDTO);
        Pregunta nuevaPregunta = preguntaRepository.save(pregunta);
        return convertToDTO(nuevaPregunta);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PreguntaDTO> getAll() {
        return preguntaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PreguntaDTO> findByID(Integer id) {
        return preguntaRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Transactional
    @Override
    public Optional<PreguntaDTO> update(Integer id, PreguntaDTO preguntaDTO) {
        return preguntaRepository.findById(id)
                .map(existing -> {
                    existing.setTexto(preguntaDTO.getTexto());  // Asegúrate de que existan los getters y setters
                    existing.setTipo(preguntaDTO.getTipo());  // Asegúrate de que existan los getters y setters
                    Pregunta updatedPregunta = preguntaRepository.save(existing);
                    return convertToDTO(updatedPregunta);
                });
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        preguntaRepository.deleteById(id);
    }

    private PreguntaDTO convertToDTO(Pregunta pregunta) {
        PreguntaDTO dto = new PreguntaDTO();
        dto.setId(pregunta.getId());
        dto.setTexto(pregunta.getTexto());
        dto.setTipo(pregunta.getTipo());
        return dto;
    }

    private Pregunta convertToEntity(PreguntaDTO dto) {
        Pregunta pregunta = new Pregunta();
        pregunta.setTexto(dto.getTexto());
        pregunta.setTipo(dto.getTipo());
        return pregunta;
    }
}


