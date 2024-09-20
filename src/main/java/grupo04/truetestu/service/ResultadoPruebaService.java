package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.ResultadoPrueba;
<<<<<<< HEAD
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

=======
import java.util.List;

public interface ResultadoPruebaService {
    ResultadoPrueba create(ResultadoPrueba resultadoPrueba);
    ResultadoPrueba findByID(Integer id);
    List<ResultadoPrueba> getAll();
    ResultadoPrueba update(Integer id, ResultadoPrueba resultadoPrueba);
    void delete(Integer id);
}
>>>>>>> feature/ResultadoPrueba
