package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Plan;
import java.util.List;

public interface PlanService {
    List<Plan> obtenerTodosLosPlanes();
    Plan obtenerPlanPorId(int idPlan); // Nuevo método para obtener un plan por ID
}
