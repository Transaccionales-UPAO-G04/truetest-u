package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.CarreraDTO;
import grupo04.truetestu.model.entity.Carrera;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarreraMapper {

    CarreraMapper INSTANCE = Mappers.getMapper(CarreraMapper.class);
    CarreraDTO toDto(Carrera carrera);
    Carrera toEntity(CarreraDTO carreraDTO);
}


