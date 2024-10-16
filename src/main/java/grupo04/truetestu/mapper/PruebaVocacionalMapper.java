package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.model.entity.PruebaVocacional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PruebaVocacionalMapper {
    private final ModelMapper modelMapper;

    public PruebaVocacionalMapper() {
        modelMapper = new ModelMapper();
    }

    public PruebaVocacionalDTO toDTO(PruebaVocacionalDTO pruebaVocacionalDTO) {
        return modelMapper.map(pruebaVocacionalDTO, PruebaVocacionalDTO.class);
    }

    public PruebaVocacional toEntity(PruebaVocacionalDTO pruebaVocacionalDTO) {
        return modelMapper.map(pruebaVocacionalDTO, PruebaVocacional.class);
    }
}
