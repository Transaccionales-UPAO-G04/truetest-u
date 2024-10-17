package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoPruebaRepository extends JpaRepository<ResultadoPrueba, Long> {
    // Puedes agregar métodos de consulta personalizados aquí si es necesario
}
