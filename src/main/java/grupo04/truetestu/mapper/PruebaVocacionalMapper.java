package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.model.entity.PruebaVocacional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Maper
public interface PruebaVocacionalMapper {
    PruebaVocacionalMapper INSTANCE = Mappers.getMapper(PruebaVocacionalMapper.class);

    PruebaVocacionalDTO toDTO(PruebaVocacional pruebaVocacional);
    PruebaVocacional toEntity(PruebaVocacionalDTO pruebaVocacionalDTO);
}
