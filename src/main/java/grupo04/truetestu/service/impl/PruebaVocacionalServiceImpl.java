package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.model.entity.PruebaVocacional;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.model.entity.Pregunta;
import grupo04.truetestu.model.entity.Respuesta;
import grupo04.truetestu.repository.PruebaVocacionalRepository;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.PruebaVocacionalService;
import grupo04.truetestu.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class PruebaVocacionalServiceImpl implements PruebaVocacionalService {

    private final PruebaVocacionalRepository pruebaVocacionalRepository;
    private final EstudianteRepository estudianteRepository;

    @Transactional
    @Override
    public PruebaVocacionalDTO create(PruebaVocacionalDTO pruebaVocacionalDTO) {
        // Crear nueva instancia de PruebaVocacional
        PruebaVocacional pruebaVocacional = new PruebaVocacional();
        pruebaVocacional.setNroPrueba(pruebaVocacionalDTO.getNroPrueba());
        pruebaVocacional.setFecha(pruebaVocacionalDTO.getFecha());

        // Asignar el estudiante
        Estudiante estudiante = estudianteRepository.findById(pruebaVocacionalDTO.getIdEstudiante())
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con id: " + pruebaVocacionalDTO.getIdEstudiante()));
        pruebaVocacional.setEstudiante(estudiante);

        // Manejar las preguntas y respuestas
        List<Pregunta> preguntas = pruebaVocacionalDTO.getPreguntas().stream()
                .map(preguntaDTO -> {
                    Pregunta pregunta = new Pregunta();
                    pregunta.setTexto(preguntaDTO.getTexto());
                    pregunta.setTipo(preguntaDTO.getTipo());

                    // Asignar respuestas a la pregunta
                    List<Respuesta> respuestas = preguntaDTO.getRespuestas().stream()
                            .map(respuestaDTO -> {
                                Respuesta respuesta = new Respuesta();
                                respuesta.setTexto(respuestaDTO.getTexto());
                                respuesta.setEsCorrecta(respuestaDTO.isEsCorrecta());
                                respuesta.setPregunta(pregunta); // Asignar la pregunta a la respuesta
                                return respuesta;
                            }).collect(Collectors.toList());

                    pregunta.setRespuestas(respuestas); // Asignar respuestas a la pregunta
                    pregunta.setPruebaVocacional(pruebaVocacional); // Asignar la prueba a la pregunta
                    return pregunta;
                }).collect(Collectors.toList());

        pruebaVocacional.setPreguntas(preguntas); // Asignar preguntas a la prueba vocacional

        // Guardar la prueba vocacional
        PruebaVocacional savedPruebaVocacional = pruebaVocacionalRepository.save(pruebaVocacional);

        return convertToDTO(savedPruebaVocacional);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PruebaVocacionalDTO> getAll() {
        return pruebaVocacionalRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PruebaVocacionalDTO> findByID(Integer id) {
        return pruebaVocacionalRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Transactional
    @Override
    public Optional<PruebaVocacionalDTO> update(Integer id, PruebaVocacionalDTO pruebaVocacionalDTO) {
        return pruebaVocacionalRepository.findById(id)
                .map(existing -> {
                    existing.setNroPrueba(pruebaVocacionalDTO.getNroPrueba());
                    existing.setFecha(pruebaVocacionalDTO.getFecha());
                    // Otros campos de actualización según DTO
                    PruebaVocacional updatedPruebaVocacional = pruebaVocacionalRepository.save(existing);
                    return convertToDTO(updatedPruebaVocacional);
                });
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        pruebaVocacionalRepository.deleteById(id);
    }

    // Método que convierte PruebaVocacional a PruebaVocacionalDTO
    private PruebaVocacionalDTO convertToDTO(PruebaVocacional pruebaVocacional) {
        PruebaVocacionalDTO dto = new PruebaVocacionalDTO();
        dto.setIdPruebaVocacional(pruebaVocacional.getIdPruebaVocacional());
        dto.setNroPrueba(pruebaVocacional.getNroPrueba());
        dto.setFecha(pruebaVocacional.getFecha());
        dto.setIdEstudiante(pruebaVocacional.getEstudiante().getIdEstudiante());

        // Asegúrate de incluir el nombre del estudiante si está disponible
        if (pruebaVocacional.getEstudiante() != null &&
                pruebaVocacional.getEstudiante().getNombreEstudiante() != null) {
            dto.setNombreEstudiante(pruebaVocacional.getEstudiante().getNombreEstudiante());
        }

        // Convertir los resultados de la prueba
        if (pruebaVocacional.getResultados() != null) { // Verificar que la lista no sea nula
            dto.setPruebas(pruebaVocacional.getResultados().stream()
                    .map(result -> {
                        ResultadoPruebaDTO resultDto = new ResultadoPruebaDTO();
                        resultDto.setPuntaje(result.getPuntaje());
                        resultDto.setRecomendacion(result.getRecomendacion());
                        return resultDto;
                    }).collect(Collectors.toList()));
        } else {
            dto.setPruebas(Collections.emptyList()); // O establece como lista vacía si es nula
        }

        // Convertir las preguntas
        dto.setPreguntas(pruebaVocacional.getPreguntas().stream()
                .map(pregunta -> {
                    PreguntaDTO preguntaDTO = new PreguntaDTO();
                    preguntaDTO.setId(pregunta.getId());
                    preguntaDTO.setTexto(pregunta.getTexto());
                    preguntaDTO.setTipo(pregunta.getTipo());

                    // Convertir las respuestas
                    preguntaDTO.setRespuestas(pregunta.getRespuestas().stream()
                            .map(respuesta -> {
                                RespuestaDTO respuestaDTO = new RespuestaDTO();
                                respuestaDTO.setTexto(respuesta.getTexto());
                                respuestaDTO.setEsCorrecta(respuesta.isEsCorrecta());
                                return respuestaDTO;
                            }).collect(Collectors.toList()));

                    return preguntaDTO;
                }).collect(Collectors.toList()));

        return dto;
    }
}







