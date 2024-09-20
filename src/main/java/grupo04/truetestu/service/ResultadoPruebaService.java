package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ResultadoPruebaService {
    List<ResultadoPrueba> getAll();
    Page<ResultadoPrueba> paginate(Pageable pageable);
    Optional<ResultadoPrueba> findByEstudianteId(int id);

    // Métodos adicionales para crear, actualizar y buscar por ID
    ResultadoPrueba create(ResultadoPrueba resultadoPrueba);
    ResultadoPrueba update(Integer id, ResultadoPrueba resultadoPrueba);
    ResultadoPrueba findByID(Integer id);
    void delete(Integer id);
}

