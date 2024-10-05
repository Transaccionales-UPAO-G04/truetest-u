package grupo04.truetestu.mapper;


import grupo04.truetestu.dto.RecursoDTO;
import grupo04.truetestu.model.entity.Recurso;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RecursoMapper {
    private final ModelMapper modelMapper;

    public RecursoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RecursoDTO toDTO(Recurso recurso) {
        return modelMapper.map(recurso, RecursoDTO.class);
    }

    public Recurso toEntity(RecursoDTO recursoDTO) {
        return modelMapper.map(recursoDTO, Recurso.class);
    }
}
