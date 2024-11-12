package grupo04.truetestu.service;

import grupo04.truetestu.dto.RespuestaDTO;

import java.util.List;

public interface RespuestaService {
    List<RespuestaDTO> obtenerRespuestas();
    RespuestaDTO crearRespuesta(RespuestaDTO respuestaDTO);
}

