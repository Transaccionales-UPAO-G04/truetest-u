package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.PruebaVocacional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaVocacionalRepository extends JpaRepository<PruebaVocacional, Long> {
}

