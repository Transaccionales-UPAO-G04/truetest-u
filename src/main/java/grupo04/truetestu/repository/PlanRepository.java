package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
    // Buscar por nombre o slug del plan (suponiendo que tu plan tiene estos campos)
    Optional<Plan> findByNombreOrSlug(String nombrePlan, String slug);

}
