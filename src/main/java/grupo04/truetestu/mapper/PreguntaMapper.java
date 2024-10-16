package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.model.entity.Pregunta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PreguntaMapper {
    private final ModelMapper modelMapper;

    public PreguntaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PreguntaDTO toDTO(Pregunta pregunta) {
        return modelMapper.map(pregunta, PreguntaDTO.class);
    }

    public Pregunta toEntity(PreguntaDTO preguntaDTO) {
        return modelMapper.map(preguntaDTO, Pregunta.class);
    }
}
