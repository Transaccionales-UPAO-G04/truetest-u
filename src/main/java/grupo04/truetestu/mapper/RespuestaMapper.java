package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.model.entity.Respuesta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RespuestaMapper {
    RespuestaMapper INSTANCE = Mappers.getMapper(RespuestaMapper.class);

    @Mapping(source = "pregunta.idPregunta", target = "idPregunta")
    RespuestaDTO respuestaToRespuestaDTO(Respuesta respuesta);

    @Mapping(source = "idPregunta", target = "pregunta.idPregunta")
    Respuesta respuestaDTOToRespuesta(RespuestaDTO respuestaDTO);
}