package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Plan;
import java.util.List;

public interface PlanService {
    List<Plan> obtenerTodosLosPlanes();
    Plan obtenerPlanPorId(int idPlan); // Método para obtener un plan por ID
    Plan agregarPlan(Plan plan); //Agregar nuevo plan
    void eliminarPlan(int idPlan); //Eliminar plan
    Plan modificarPlan(int idPlan, Plan plan); //Modificar plan
}
