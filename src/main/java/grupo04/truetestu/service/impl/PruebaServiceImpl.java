package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.mapper.PreguntaMapper;
import grupo04.truetestu.model.entity.PruebaVocacional;
import grupo04.truetestu.repository.PruebaVocacionalRepository;
import grupo04.truetestu.service.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PruebaServiceImpl implements PruebaService {

    private final PruebaVocacionalRepository pruebaVocacionalRepository;

    @Autowired
    public PruebaServiceImpl(PruebaVocacionalRepository pruebaVocacionalRepository) {
        this.pruebaVocacionalRepository = pruebaVocacionalRepository;
    }

    @Override
    public List<PreguntaDTO> obtenerPreguntas() {
        // Implementación para obtener preguntas
        return null;
    }

    @Override
    public void guardarRespuesta(RespuestaDTO respuestaDTO) {
        // Implementación para guardar la respuesta
    }

    @Override
    public PruebaVocacionalDTO calcularResultado(List<RespuestaDTO> respuestas) {
        // Implementación para calcular el resultado
        return null;
    }

    @Override
    public List<PruebaVocacionalDTO> obtenerPruebasVocacionales() {
        List<PruebaVocacional> pruebas = pruebaVocacionalRepository.findAll();
        return pruebas.stream()
                .map(PreguntaMapper.INSTANCE::pruebaVocacionalToPruebaVocacionalDTO)
                .collect(Collectors.toList());
    }
}
