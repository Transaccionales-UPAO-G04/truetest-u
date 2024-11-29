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
        // Mapeo automático con ModelMapper
        HorarioDTO horarioDTO = modelMapper.map(horario, HorarioDTO.class);

        // Si el horario tiene un estudiante asociado, asignamos el nombre del estudiante al DTO
        if (horario.getEstudiante() != null) {
            horarioDTO.setNombre(horario.getEstudiante().getNombre());
        } else {
            horarioDTO.setNombre(null);  // Si no hay estudiante, asignamos null
        }
        return horarioDTO;
    }


    public Horario toEntity(HorarioDTO horarioDTO) {
        return modelMapper.map(horarioDTO, Horario.class);
    }
}
