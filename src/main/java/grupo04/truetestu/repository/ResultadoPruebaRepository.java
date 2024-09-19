package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoPruebaRepository extends JpaRepository<ResultadoPrueba, Integer> {
    // Métodos personalizados de consulta, si es necesario.
}
