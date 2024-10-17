package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.model.entity.Pregunta;
import grupo04.truetestu.model.entity.PruebaVocacional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PreguntaMapper {
    PreguntaMapper INSTANCE = Mappers.getMapper(PreguntaMapper.class);

    PreguntaDTO preguntaToPreguntaDTO(Pregunta pregunta);
    Pregunta preguntaDTOToPregunta(PreguntaDTO preguntaDTO);

    PruebaVocacionalDTO pruebaVocacionalToPruebaVocacionalDTO(PruebaVocacional pruebaVocacional);
    PruebaVocacional pruebaVocacionalDTOToPruebaVocacional(PruebaVocacionalDTO pruebaVocacionalDTO);
}
