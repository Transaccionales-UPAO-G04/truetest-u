package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.model.entity.Respuestas;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RespuestaMapper {
    private final ModelMapper modelMapper;

    public RespuestaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RespuestaDTO toDTO(Respuestas respuesta) {
        return modelMapper.map(respuesta, RespuestaDTO.class);
    }

    public Respuestas toEntity(RespuestaDTO respuestaDTO) {
        return modelMapper.map(respuestaDTO, Respuestas.class);
    }
}
