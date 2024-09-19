package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ResultadoPruebaService{
    List<ResultadoPrueba> getAll();
    Page<ResultadoPrueba> paginate(Pageable pageable);
    Optional<ResultadoPrueba> findByEstudianteId(int id);
}
