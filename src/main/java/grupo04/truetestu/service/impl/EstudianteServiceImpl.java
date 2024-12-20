package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.exception.BadRequestException;
import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.mapper.EstudianteMapper;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.EstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    @Override
    public List<EstudianteDTO> findAll() {
        List<Estudiante> estudiantes =  estudianteRepository.findAll();
        return estudiantes.stream()
                .map(estudianteMapper::toDTO)
                .toList();
    }


    @Override
    public EstudianteDTO findById(int id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("El estudiante con ID "+id+" no fu eencontrado"));
        return estudianteMapper.toDTO(estudiante);
    }

    @Transactional
    @Override
    public EstudianteDTO update(Integer id, EstudianteDTO updateEstudianteDTO) {
        // Encuentra el estudiante en la base de datos
        Estudiante estudianteFromDb = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante con ID " + id + " no encontrado"));
        // Guarda los cambios en la base de datos
        estudianteFromDb = estudianteRepository.save(estudianteFromDb);

        // Retorna el estudiante actualizado convertido a DTO
        return estudianteMapper.toDTO(estudianteFromDb);
    }


    @Transactional
    @Override
    public void delete(Integer id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Estudiante con ID " + id + " no encontrado"));
        estudianteRepository.delete(estudiante);
    }


}

