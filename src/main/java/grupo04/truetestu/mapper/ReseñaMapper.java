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

    // Convertir de entidad a DTO
    public ReseñaDTO toDTO(Reseña reseña) {
        ReseñaDTO reseñaDTO = modelMapper.map(reseña, ReseñaDTO.class);

        // Verificar si el estudiante está presente y asignar su nombre al DTO
        if (reseña.getEstudiante() != null) {
            reseñaDTO.setNombreEstudiante(reseña.getEstudiante().getNombre());
        }

        return reseñaDTO;
    }

    public Reseña toEntity(ReseñaDTO reseñaDTO){
        return modelMapper.map(reseñaDTO, Reseña.class);
    }
}
