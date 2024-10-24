package grupo04.truetestu.service;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.RespuestaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface PruebaVocacionalService {
    // Métodos básicos CRUD
    List<PruebaVocacionalDTO> obtenerPruebasVocacionales();
    PruebaVocacionalDTO crearPruebaVocacional(PruebaVocacionalDTO pruebaVocacionalDTO);
    PruebaVocacionalDTO obtenerPruebaVocacionalPorId(Long id);
    PruebaVocacionalDTO actualizarPruebaVocacional(Long id, PruebaVocacionalDTO pruebaVocacionalDTO);
    void eliminarPruebaVocacional(Long id);

    // Métodos específicos de la prueba vocacional
    List<PreguntaDTO> obtenerPreguntas();
    void guardarRespuesta(RespuestaDTO respuestaDTO);
    PruebaVocacionalDTO calcularResultado(List<RespuestaDTO> respuestas);

    // Métodos de paginación (si los necesitas)
    default Page<PruebaVocacionalDTO> paginate(Pageable pageable) {
        throw new UnsupportedOperationException("Paginación no implementada");
    }
}