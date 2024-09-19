package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoPlan;

public interface EstudianteService {

    Estudiante registerEstudiante(Estudiante estudiante);
    Estudiante sesionEstudiante(Estudiante estudiante);

    Estudiante findById(int id);
    void inhabilitarCuenta(int id);
    void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan);


    Estudiante update(Integer id, Estudiante updateEstudiante);
}
