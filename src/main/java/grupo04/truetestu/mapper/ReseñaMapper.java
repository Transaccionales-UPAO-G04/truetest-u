package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.ReseñaDTO;
import grupo04.truetestu.model.entity.Reseña;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReseñaMapper {
    private final ModelMapper modelMapper;

    public ReseñaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ReseñaDTO toDTO(Reseña reseña){
        return modelMapper.map(reseña, ReseñaDTO.class);
    }

    public Reseña toEntity(ReseñaDTO reseñaDTO){
        return modelMapper.map(reseñaDTO, Reseña.class);
    }
}
