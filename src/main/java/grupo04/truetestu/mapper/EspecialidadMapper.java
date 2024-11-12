package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.EspecialidadDTO;
import grupo04.truetestu.model.entity.Especialidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadMapper {

    private final ModelMapper modelMapper;

    public EspecialidadMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EspecialidadDTO toDto(Especialidad especialidad) {
        return modelMapper.map(especialidad, EspecialidadDTO.class);
    }

    public Especialidad toEntity(EspecialidadDTO especialidadDTO) {
        return modelMapper.map(especialidadDTO, Especialidad.class);
    }
}
