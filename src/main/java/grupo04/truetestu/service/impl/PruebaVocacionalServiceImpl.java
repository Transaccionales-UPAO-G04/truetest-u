package grupo04.truetestu.service.impl;

import grupo04.truetestu.Infra.exception.ResourceNotFoundException;
import grupo04.truetestu.model.entity.PruebaVocacional;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.repository.PruebaVocacionalRepository;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.PruebaVocacionalService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public PruebaVocacionalDTO create(PruebaVocacionalDTO pruebaVocacionalDto) {
        PruebaVocacional pruebaVocacional = new PruebaVocacional();

        // Mapear los datos del DTO a la entidad.
        pruebaVocacional.setNroPrueba(pruebaVocacionalDto.getNroPrueba());
        pruebaVocacional.setFecha(pruebaVocacionalDto.getFecha());

        // Buscar y asignar el estudiante.
        Estudiante estudiante = estudianteRepository.findById(pruebaVocacionalDto.getIdEstudiante())
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con id: "
                        + pruebaVocacionalDto.getIdEstudiante()));
        pruebaVocacional.setEstudiante(estudiante);

        // Mapear los resultados de las pruebas.
        List<ResultadoPrueba> pruebas = pruebaVocacionalDto.getPruebas().stream()
                .map(dto -> {
                    ResultadoPrueba resultadoPrueba = new ResultadoPrueba();
                    resultadoPrueba.setPuntaje(dto.getPuntaje());
                    resultadoPrueba.setRecomendacion(dto.getRecomendacion());
                    resultadoPrueba.setPruebaVocacional(pruebaVocacional);
                    return resultadoPrueba;
                }).collect(Collectors.toList());
        pruebaVocacional.setPruebas(pruebas);

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
    public Page<PruebaVocacionalDTO> paginate(Pageable pageable) {
        return pruebaVocacionalRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PruebaVocacionalDTO> findByID(Integer id) {
        return pruebaVocacionalRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Transactional
    @Override
    public Optional<PruebaVocacionalDTO> update(Integer id, PruebaVocacionalDTO pruebaVocacionalDto) {
        return pruebaVocacionalRepository.findById(id).map(existing -> {
            existing.setNroPrueba(pruebaVocacionalDto.getNroPrueba());
            existing.setFecha(pruebaVocacionalDto.getFecha());

            Estudiante estudiante = estudianteRepository.findById(pruebaVocacionalDto.getIdEstudiante())
                    .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado con id: "
                            + pruebaVocacionalDto.getIdEstudiante()));
            existing.setEstudiante(estudiante);

            List<ResultadoPrueba> pruebas = pruebaVocacionalDto.getPruebas().stream()
                    .map(dto -> {
                        ResultadoPrueba resultadoPrueba = new ResultadoPrueba();
                        resultadoPrueba.setPuntaje(dto.getPuntaje());
                        resultadoPrueba.setRecomendacion(dto.getRecomendacion());
                        resultadoPrueba.setPruebaVocacional(existing);
                        return resultadoPrueba;
                    }).collect(Collectors.toList());
            existing.setPruebas(pruebas);

            PruebaVocacional updatedPruebaVocacional = pruebaVocacionalRepository.save(existing);
            return convertToDTO(updatedPruebaVocacional);
        });
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        pruebaVocacionalRepository.deleteById(id);
    }

    private PruebaVocacionalDTO convertToDTO(PruebaVocacional pruebaVocacional) {
        PruebaVocacionalDTO dto = new PruebaVocacionalDTO();
        dto.setIdPruebaVocacional(pruebaVocacional.getIdPruebaVocacional());
        dto.setNroPrueba(pruebaVocacional.getNroPrueba());
        dto.setFecha(pruebaVocacional.getFecha());
        dto.setIdEstudiante(pruebaVocacional.getEstudiante().getIdEstudiante());
        dto.setPruebas(pruebaVocacional.getPruebas().stream()
                .map(resultado -> {
                    ResultadoPruebaDTO resultadoDto = new ResultadoPruebaDTO();
                    resultadoDto.setPuntaje(resultado.getPuntaje());
                    resultadoDto.setRecomendacion(resultado.getRecomendacion());
                    return resultadoDto;
                }).collect(Collectors.toList()));
        return dto;
    }
}

