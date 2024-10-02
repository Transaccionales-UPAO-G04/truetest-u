package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.repository.PlanRepository;
import grupo04.truetestu.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> obtenerTodosLosPlanes() {
        return planRepository.findAll();
    }
}
