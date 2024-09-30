package grupo04.truetestu.service;

import grupo04.truetestu.dto.PreguntaDTO;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    PreguntaDTO create(PreguntaDTO preguntaDTO);

    List<PreguntaDTO> getAll();

    Optional<PreguntaDTO> findByID(Integer id);

    Optional<PreguntaDTO> update(Integer id, PreguntaDTO preguntaDTO);

    void delete(Integer id);
}


