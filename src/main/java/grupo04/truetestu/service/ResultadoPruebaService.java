package grupo04.truetestu.service;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResultadoPruebaService {
    // Métodos para gestionar resultados de prueba
    ResultadoPruebaDTO create(ResultadoPruebaDTO resultadoPruebaDTO);
    ResultadoPruebaDTO findByID(Integer id);

    List<ResultadoPruebaDTO> getAll();

    ResultadoPruebaDTO update(Integer id, ResultadoPruebaDTO updatedResultadoPruebaDTO);
    void delete(Integer id);

    // Métodos adicionales
    Page<ResultadoPruebaDTO> paginate(Pageable pageable);

    ResultadoPruebaDTO findByEstudianteId(int id);
}

