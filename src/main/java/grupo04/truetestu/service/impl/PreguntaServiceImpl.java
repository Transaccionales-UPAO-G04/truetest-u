package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.exception.ResourceNotFoundException;
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
        Pregunta pregunta = new Pregunta();
        pregunta.setTexto(preguntaDTO.getTexto());
        pregunta.setTipo(preguntaDTO.getTipo());
        // Otros campos si es necesario

        Pregunta savedPregunta = preguntaRepository.save(pregunta);
        return convertToDTO(savedPregunta);
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
    public Optional<PreguntaDTO> update(Integer id, PreguntaDTO nuevaPreguntaDTO) {
        return preguntaRepository.findById(id)
                .map(existing -> {
                    existing.setTexto(nuevaPreguntaDTO.getTexto());
                    existing.setTipo(nuevaPreguntaDTO.getTipo());
                    // Otras actualizaciones según sea necesario
                    Pregunta updatedPregunta = preguntaRepository.save(existing);
                    return convertToDTO(updatedPregunta);
                });
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        if (!preguntaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pregunta no encontrada con id: " + id);
        }
        preguntaRepository.deleteById(id);
    }

    // Método que convierte Pregunta a PreguntaDTO
    private PreguntaDTO convertToDTO(Pregunta pregunta) {
        PreguntaDTO dto = new PreguntaDTO();
        dto.setId(pregunta.getId());
        dto.setTexto(pregunta.getTexto());
        dto.setTipo(pregunta.getTipo());
        // Otros campos si es necesario
        return dto;
    }
}




