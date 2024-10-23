package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.model.entity.Pregunta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PreguntaMapper {
    PreguntaMapper INSTANCE = Mappers.getMapper(PreguntaMapper.class);

    PreguntaDTO toDTO(Pregunta pregunta);
    Pregunta toEntity(PreguntaDTO preguntaDTO);
}

