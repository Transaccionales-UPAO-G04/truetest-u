package grupo04.truetestu.mapper;


import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.model.entity.Estudiante;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    private final ModelMapper modelMapper;
    public EstudianteMapper() {

        modelMapper = new ModelMapper();
    }

    public EstudianteDTO toDTO(Estudiante estudiante) {

        return modelMapper.map(estudiante, EstudianteDTO.class);
    }

    public Estudiante toEntity(EstudianteDTO estudianteDTO) {
        return modelMapper.map(estudianteDTO, Estudiante.class);
    }
}
