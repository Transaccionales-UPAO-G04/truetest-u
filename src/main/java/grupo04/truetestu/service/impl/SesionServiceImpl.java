package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.SesionDTO;
import grupo04.truetestu.exception.BadRequestException;
import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.mapper.SesionMapper;
import grupo04.truetestu.model.entity.Reseña;
import grupo04.truetestu.model.entity.Sesion;
import grupo04.truetestu.repository.SesionRepository;
import grupo04.truetestu.service.SesionService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor

public class SesionServiceImpl implements SesionService {

    private final SesionRepository sesionRepository;
    private SesionMapper sesionMapper;

    @Override
    public List<SesionDTO> findAll() {
        List<Sesion> sesion = sesionRepository.findAll();
        return sesion.stream()
                .map(sesionMapper::toDto)
                .toList();
    }

    @Override
    public SesionDTO findById(int id) {
        Sesion sesion = sesionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sesion no encontrada con id: " + id));
        return sesionMapper.toDto(sesion);
    }

    @Override
    public SesionDTO create(SesionDTO sesionDTO) {
        // Verificar si ya existe una sesion con el mismo horario
        sesionRepository.findByFechaAndTiempo(sesionDTO.getFecha(), sesionDTO.getTiempo())
                .ifPresent(existingCategory -> {
                    throw new BadRequestException("ya existe una sesion programada con ese horario");
                });

        Sesion sesion = sesionMapper.toEntity(sesionDTO);
        sesion = sesionRepository.save(sesion);
        return sesionMapper.toDto(sesion);
    }

    //para que el mentor pueda ingresar un link en esa sesion
    @Transactional
    @Override
    public SesionDTO updateByLinkSesionPrivada(Integer id, SesionDTO updateSesionDTO) {
        Sesion sesionFromDb = sesionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La sesion no fue encontrada"));

        sesionFromDb.setLinkSesionPrivada(updateSesionDTO.getLinkSesionPrivada());
        sesionFromDb = sesionRepository.save(sesionFromDb);
        return sesionMapper.toDto(sesionFromDb);
    }

    @Override
    public void delete(int id) {
        // Buscar la reseña por ID antes de eliminarla
        Sesion sesion = sesionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada con id: " + id));

        // Eliminar la reseña
        sesionRepository.deleteById(id);

    }
}
