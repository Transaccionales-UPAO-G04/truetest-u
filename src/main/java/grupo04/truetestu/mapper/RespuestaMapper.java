package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.model.entity.Respuesta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RespuestaMapper {
    RespuestaMapper INSTANCE = Mappers.getMapper(RespuestaMapper.class);

    RespuestaDTO respuestaToRespuestaDTO(Respuesta respuesta);
    Respuesta respuestaDTOToRespuesta(RespuestaDTO respuestaDTO);
}

