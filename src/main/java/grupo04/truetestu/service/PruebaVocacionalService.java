package grupo04.truetestu.service;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.RespuestaDTO;

import java.util.List;

public interface PruebaVocacionalService {
    List<PruebaVocacionalDTO> obtenerPruebasVocacionales();
    PruebaVocacionalDTO crearPruebaVocacional(PruebaVocacionalDTO pruebaVocacionalDTO);
    List<PreguntaDTO> obtenerPreguntas(); // Método para obtener preguntas
    void guardarRespuesta(RespuestaDTO respuestaDTO); // Método para guardar respuesta
    PruebaVocacionalDTO calcularResultado(List<RespuestaDTO> respuestas); // Método para calcular resultado
}
