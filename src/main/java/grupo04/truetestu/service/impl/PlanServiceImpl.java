package grupo04.truetestu.service.impl;

import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.repository.PlanRepository;
import grupo04.truetestu.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .orElseThrow(() -> new ResourceNotFoundException("Plan no encontrado con ID: " + idPlan));
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
                .orElseThrow(() -> new ResourceNotFoundException("Plan no encontrado con ID: " + idPlan));
        planExistente.setNombre(plan.getNombre());
        planExistente.setPrecio(plan.getPrecio());
        planExistente.setCreatedAt(plan.getCreatedAt());
        planExistente.setDescripcionPlan(plan.getDescripcionPlan());
        planExistente.setFechaFin(plan.getFechaFin());
        return planRepository.save(planExistente);
    }

    // Método para obtener el monto de un plan por su ID
    @Override
    @Transactional(readOnly = true)
    public double getPlanAmount(int IdPlan) {
        Plan plan = planRepository.findById(IdPlan)
                .orElseThrow(() -> new ResourceNotFoundException("Plan no encontrado con ID: " + IdPlan));
        return plan.getPrecio();
    }
}
