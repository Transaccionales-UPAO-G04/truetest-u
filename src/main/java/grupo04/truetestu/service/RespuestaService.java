package grupo04.truetestu.service;

import grupo04.truetestu.dto.RespuestaDTO;

import java.util.List;
import java.util.Optional;

public interface RespuestaService {
    RespuestaDTO create(RespuestaDTO respuestaDTO);
    List<RespuestaDTO> getAll();
    Optional<RespuestaDTO> findByID(Integer id);
    Optional<RespuestaDTO> update(Integer id, RespuestaDTO respuestaDTO);
    void delete(Integer id);
}


