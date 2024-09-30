package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.model.entity.PruebaVocacional;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.ResultadoPrueba;
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

@RequiredArgsConstructor
@Service
public class PruebaVocacionalServiceImpl implements PruebaVocacionalService {

    private final PruebaVocacionalRepository pruebaVocacionalRepository;
    private final EstudianteRepository estudianteRepository;

    @Transactional
    @Override
    public PruebaVocacionalDTO create(PruebaVocacionalDTO pruebaVocacionalDTO) {
        PruebaVocacional pruebaVocacional = convertToEntity(pruebaVocacionalDTO);
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

    // Métodos auxiliares para conversión
    private PruebaVocacionalDTO convertToDTO(PruebaVocacional pruebaVocacional) {
        PruebaVocacionalDTO dto = new PruebaVocacionalDTO();
        dto.setIdPruebaVocacional(pruebaVocacional.getIdPruebaVocacional());
        dto.setNroPrueba(pruebaVocacional.getNroPrueba());
        dto.setFecha(pruebaVocacional.getFecha());
        dto.setIdEstudiante(pruebaVocacional.getEstudiante().getIdEstudiante());
        dto.setPruebas(pruebaVocacional.getPruebas().stream()
                .map(result -> {
                    ResultadoPruebaDTO resultDto = new ResultadoPruebaDTO(); // Asegúrate de que esta línea no tenga errores
                    resultDto.setPuntaje(result.getPuntaje());
                    resultDto.setRecomendacion(result.getRecomendacion());
                    return resultDto;
                }).collect(Collectors.toList()));
        return dto;
    }


    private PruebaVocacional convertToEntity(PruebaVocacionalDTO dto) {
        PruebaVocacional pruebaVocacional = new PruebaVocacional();
        pruebaVocacional.setNroPrueba(dto.getNroPrueba());
        pruebaVocacional.setFecha(dto.getFecha());

        // Buscar y asignar el estudiante
        Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con id: " + dto.getIdEstudiante()));
        pruebaVocacional.setEstudiante(estudiante);

        // Mapear los resultados de las pruebas
        List<ResultadoPrueba> resultados = dto.getPruebas().stream()
                .map(resultDto -> {
                    ResultadoPrueba resultadoPrueba = new ResultadoPrueba();
                    resultadoPrueba.setPuntaje(resultDto.getPuntaje());
                    resultadoPrueba.setRecomendacion(resultDto.getRecomendacion());
                    resultadoPrueba.setPruebaVocacional(pruebaVocacional);
                    return resultadoPrueba;
                }).collect(Collectors.toList());
        pruebaVocacional.setPruebas(resultados);

        return pruebaVocacional;
    }
}


