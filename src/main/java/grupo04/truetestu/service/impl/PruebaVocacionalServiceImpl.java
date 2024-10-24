package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.mapper.PruebaVocacionalMapper;
import grupo04.truetestu.mapper.PreguntaMapper;
import grupo04.truetestu.mapper.RespuestaMapper;
import grupo04.truetestu.model.entity.PruebaVocacional;
import grupo04.truetestu.model.entity.Pregunta;
import grupo04.truetestu.model.entity.Respuesta;
import grupo04.truetestu.repository.PruebaVocacionalRepository;
import grupo04.truetestu.repository.PreguntaRepository;
import grupo04.truetestu.repository.RespuestaRepository;
import grupo04.truetestu.service.PruebaVocacionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class PruebaVocacionalServiceImpl implements PruebaVocacionalService {

    private final PruebaVocacionalRepository pruebaVocacionalRepository;
    private final PreguntaRepository preguntaRepository;
    private final RespuestaRepository respuestaRepository;

    @Autowired
    public PruebaVocacionalServiceImpl(PruebaVocacionalRepository pruebaVocacionalRepository,
                                       PreguntaRepository preguntaRepository,
                                       RespuestaRepository respuestaRepository) {
        this.pruebaVocacionalRepository = pruebaVocacionalRepository;
        this.preguntaRepository = preguntaRepository;
        this.respuestaRepository = respuestaRepository;
    }

    @Override
    public List<PruebaVocacionalDTO> obtenerPruebasVocacionales() {
        List<PruebaVocacional> pruebas = pruebaVocacionalRepository.findAll();
        return pruebas.stream()
                .map(PruebaVocacionalMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PruebaVocacionalDTO crearPruebaVocacional(PruebaVocacionalDTO pruebaVocacionalDTO) {
        PruebaVocacional prueba = PruebaVocacionalMapper.INSTANCE.toEntity(pruebaVocacionalDTO);
        PruebaVocacional nuevaPrueba = pruebaVocacionalRepository.save(prueba);
        return PruebaVocacionalMapper.INSTANCE.toDTO(nuevaPrueba);
    }

    @Override
    public List<PreguntaDTO> obtenerPreguntas() {
        List<Pregunta> preguntas = preguntaRepository.findAll();
        return preguntas.stream()
                .map(PreguntaMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void guardarRespuesta(RespuestaDTO respuestaDTO) {
        Respuesta respuesta = RespuestaMapper.INSTANCE.respuestaDTOToRespuesta(respuestaDTO);
        respuestaRepository.save(respuesta);
    }

    @Override
    public PruebaVocacionalDTO calcularResultado(List<RespuestaDTO> respuestas) {
        Map<String, Integer> puntajesPorArea = calcularPuntajesPorArea(respuestas);
        String carreraRecomendada = determinarCarreraRecomendada(puntajesPorArea);
        int puntajeTotal = puntajesPorArea.values().stream().mapToInt(Integer::intValue).sum();

        PruebaVocacional prueba = new PruebaVocacional();
        prueba.setNombre("Resultado de la prueba vocacional");
        prueba.setDescripcion("Basado en tus respuestas, tu carrera recomendada es: " + carreraRecomendada +
                ". Puntaje total: " + puntajeTotal);

        StringBuilder detallesPuntajes = new StringBuilder("Desglose de puntajes por área:\n");
        puntajesPorArea.forEach((area, puntaje) ->
                detallesPuntajes.append(area).append(": ").append(puntaje).append("\n")
        );
        prueba.setDescripcion(prueba.getDescripcion() + "\n" + detallesPuntajes.toString());

        PruebaVocacional pruebaGuardada = pruebaVocacionalRepository.save(prueba);
        return PruebaVocacionalMapper.INSTANCE.toDTO(pruebaGuardada);
    }

    private Map<String, Integer> calcularPuntajesPorArea(List<RespuestaDTO> respuestas) {
        Map<String, Integer> puntajesPorArea = new HashMap<>();
        puntajesPorArea.put("Ciencias", 0);
        puntajesPorArea.put("Humanidades", 0);
        puntajesPorArea.put("Artes", 0);
        puntajesPorArea.put("Negocios", 0);

        for (RespuestaDTO respuesta : respuestas) {
            String area = determinarAreaDePregunta(respuesta.getIdPregunta());
            int puntajeActual = puntajesPorArea.getOrDefault(area, 0);
            puntajesPorArea.put(area, puntajeActual + respuesta.getPuntuacion());
        }

        return puntajesPorArea;
    }

    private String determinarAreaDePregunta(Long idPregunta) {
        String[] areas = {"Ciencias", "Humanidades", "Artes", "Negocios"};
        return areas[(int) (idPregunta % areas.length)];
    }

    private String determinarCarreraRecomendada(Map<String, Integer> puntajesPorArea) {
        String areaMaxPuntaje = puntajesPorArea.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No determinado");

        Map<String, String> carrerasPorArea = new HashMap<>();
        carrerasPorArea.put("Ciencias", "Ingeniería");
        carrerasPorArea.put("Humanidades", "Psicología");
        carrerasPorArea.put("Artes", "Diseño Gráfico");
        carrerasPorArea.put("Negocios", "Administración de Empresas");

        return carrerasPorArea.getOrDefault(areaMaxPuntaje, "Carrera no determinada");
    }

    public PruebaVocacionalDTO obtenerPruebaVocacionalPorId(Long id) {
        PruebaVocacional prueba = pruebaVocacionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prueba vocacional no encontrada"));
        return PruebaVocacionalMapper.INSTANCE.toDTO(prueba);
    }

    public void eliminarPruebaVocacional(Long id) {
        pruebaVocacionalRepository.deleteById(id);
    }

    public PruebaVocacionalDTO actualizarPruebaVocacional(Long id, PruebaVocacionalDTO pruebaVocacionalDTO) {
        PruebaVocacional pruebaExistente = pruebaVocacionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prueba vocacional no encontrada"));

        pruebaExistente.setNombre(pruebaVocacionalDTO.getNombre());
        pruebaExistente.setDescripcion(pruebaVocacionalDTO.getDescripcion());

        PruebaVocacional pruebaActualizada = pruebaVocacionalRepository.save(pruebaExistente);
        return PruebaVocacionalMapper.INSTANCE.toDTO(pruebaActualizada);
    }
    @Override
    public Page<PruebaVocacionalDTO> paginate(Pageable pageable) {
        return pruebaVocacionalRepository.findAll(pageable)
                .map(PruebaVocacionalMapper.INSTANCE::toDTO);
    }
}

