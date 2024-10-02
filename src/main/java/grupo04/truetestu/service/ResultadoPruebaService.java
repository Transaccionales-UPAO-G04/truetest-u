package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ResultadoPruebaService {
    // Métodos para gestionar resultados de prueba
    ResultadoPrueba create(ResultadoPrueba resultadoPrueba);
    ResultadoPrueba findByID(Integer id);
    List<ResultadoPrueba> getAll();
    ResultadoPrueba update(Integer id, ResultadoPrueba resultadoPrueba);
    void delete(Integer id);

    // Métodos adicionales
    Page<ResultadoPrueba> paginate(Pageable pageable);
    Optional<ResultadoPrueba> findByEstudianteId(int id);
}

