package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Especialidad;
import grupo04.truetestu.repository.VisualizarEspecialidadRepository;
import grupo04.truetestu.service.VisualizarEspecialidadService;
import grupo04.truetestu.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VisualizarEspecialidadServiceImpl implements VisualizarEspecialidadService {

    private final VisualizarEspecialidadRepository especialidadRepository;

    @Transactional(readOnly = true)
    @Override
    public Especialidad findByID(Integer id) {
        return especialidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Especialidad> getAll() {
        return especialidadRepository.findAll();
    }
}
