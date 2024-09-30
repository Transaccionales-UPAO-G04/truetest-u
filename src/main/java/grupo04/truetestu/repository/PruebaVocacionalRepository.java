package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.PruebaVocacional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PruebaVocacionalRepository extends JpaRepository<PruebaVocacional, Integer> {
    // Métodos adicionales si es necesario
}
