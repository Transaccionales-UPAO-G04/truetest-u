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

    // Método para obtener todos los planes
    @Override
    public List<Plan> obtenerTodosLosPlanes() {
        return planRepository.findAll();
    }

    // Método para obtener un plan por su ID
    @Override
    public Plan obtenerPlanPorId(int idPlan) {
        return planRepository.findById(idPlan)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
    }
    // Método para agregar un nuevo plan
    @Override
    public Plan agregarPlan(Plan plan) {
        return planRepository.save(plan);
    }
    // Método para eliminar un plan
    @Override
    public void eliminarPlan(int idPlan) {
        planRepository.deleteById(idPlan);
    }

    // Método para modificar un plan existente
    @Override
    public Plan modificarPlan(int idPlan, Plan plan) {
        Plan planExistente = planRepository.findById(idPlan)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        planExistente.setNombrePlan(plan.getNombrePlan());
        planExistente.setPrecio(plan.getPrecio());
        planExistente.setDescripcionPlan(plan.getDescripcionPlan());
        planExistente.setFechaInicio(plan.getFechaInicio());
        planExistente.setFechaFin(plan.getFechaFin());
        return planRepository.save(planExistente);
    }

}
