package grupo04.truetestu.mapper;


import grupo04.truetestu.dto.SesionDTO;
import grupo04.truetestu.model.entity.Sesion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SesionMapper {

    private final ModelMapper modelMapper;
    public SesionMapper(ModelMapper modelMapper) {this.modelMapper = new ModelMapper();}
    public SesionDTO toDto(Sesion sesion) {return modelMapper.map(sesion, SesionDTO.class);}
    public Sesion toEntity(SesionDTO sesionDTO) {return modelMapper.map(sesionDTO, Sesion.class);}

}
