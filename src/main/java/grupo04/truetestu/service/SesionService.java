package grupo04.truetestu.service;

import grupo04.truetestu.dto.SesionDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SesionService {
    List<SesionDTO> findAll();
    SesionDTO findById(int id);
    SesionDTO create(SesionDTO sesion);

    //para que el mentor pueda ingresar un link en esa sesion
    @Transactional
    SesionDTO updateByLinkSesionPrivada(Integer id, SesionDTO updateSesionDTO);

    @Transactional
    void delete(int id);
}
