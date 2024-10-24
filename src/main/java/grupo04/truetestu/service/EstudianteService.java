package grupo04.truetestu.service;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta; // Asegúrate de importar esto
import grupo04.truetestu.model.enums.EstadoPlan;

import java.util.List;

public interface EstudianteService {
    List<Estudiante> findAll();
    Estudiante findById(int id);
    Estudiante registerEstudiante(Estudiante estudiante);
    Estudiante sesionEstudiante(Estudiante estudiante);
    EstudianteDTO update(Integer id, EstudianteDTO updateEstudianteDTO);
    void inhabilitarCuenta(int id);
    void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan);
    void cambiarCuenta(int id, EstadoCuenta nuevoEstado); // Agrega este método
}


