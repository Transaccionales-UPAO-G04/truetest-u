package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.HorarioDTO;
import grupo04.truetestu.model.entity.Horario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HorarioMapper {

    private final ModelMapper modelMapper;

    public HorarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HorarioDTO toDTO(Horario horario) {
        return modelMapper.map(horario, HorarioDTO.class);
    }

    public Horario toEntity(HorarioDTO horarioDTO) {
        return modelMapper.map(horarioDTO, Horario.class);
    }
}
