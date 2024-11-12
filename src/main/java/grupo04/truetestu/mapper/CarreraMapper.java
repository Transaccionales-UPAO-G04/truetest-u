package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.CarreraDTO;
import grupo04.truetestu.model.entity.Carrera;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarreraMapper {
    private final ModelMapper modelMapper;

    public CarreraMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CarreraDTO toDTO(Carrera carrera) {
        return modelMapper.map(carrera, CarreraDTO.class);
    }

    public Carrera toEntity(CarreraDTO carreraDTO) {
        return modelMapper.map(carreraDTO, Carrera.class);
    }


}
