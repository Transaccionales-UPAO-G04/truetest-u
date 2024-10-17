package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResultadoPruebaMapper {

    ResultadoPruebaMapper INSTANCE = Mappers.getMapper(ResultadoPruebaMapper.class);

    ResultadoPruebaDTO toDto(ResultadoPrueba entity);
    ResultadoPrueba toEntity(ResultadoPruebaDTO dto);
}

