package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.repository.PlanRepository;
import grupo04.truetestu.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

    @Override
    public List<Plan> obtenerTodosLosPlanes() {
        return planRepository.findAll();
    }

    @Override
    public Plan obtenerPlanPorId(int idPlan) {
        return planRepository.findById(idPlan)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
    }
}
