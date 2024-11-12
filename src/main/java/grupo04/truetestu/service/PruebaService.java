package grupo04.truetestu.service;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.RespuestaDTO;

import java.util.List;

public interface PruebaService {
    List<PreguntaDTO> obtenerPreguntas();
    void guardarRespuesta(RespuestaDTO respuestaDTO);
    PruebaVocacionalDTO calcularResultado(List<RespuestaDTO> respuestas);
    List<PruebaVocacionalDTO> obtenerPruebasVocacionales(); // Nuevo método
}
