package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ResultadoPruebaMapper {
    private final ModelMapper modelMapper;

    public ResultadoPruebaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ResultadoPruebaDTO toDTO(ResultadoPrueba resultadoPrueba) {
        return modelMapper.map(resultadoPrueba, ResultadoPruebaDTO.class);
    }

    public ResultadoPrueba toEntity(ResultadoPruebaDTO resultadoPruebaDTO) {
        return modelMapper.map(resultadoPruebaDTO, ResultadoPrueba.class);
    }

}
