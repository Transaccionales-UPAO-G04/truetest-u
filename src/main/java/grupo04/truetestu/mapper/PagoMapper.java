package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.PagoDTO;
import grupo04.truetestu.model.entity.Pago;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PagoMapper {
    private final ModelMapper modelMapper;

    public PagoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PagoDTO toDto(Pago pago) {
        return modelMapper.map(pago, PagoDTO.class);
    }

    public Pago toEntity(PagoDTO dto) {
        return modelMapper.map(dto, Pago.class);
    }
}
