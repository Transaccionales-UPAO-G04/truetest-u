package grupo04.truetestu.service;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;

import java.util.List;

public interface EstudianteService {


    List<EstudianteDTO> findAll();
    EstudianteDTO findById(int idEstudiante);
    EstudianteDTO update(Integer id, EstudianteDTO updateEstudianteDTO);
    void delete(Integer id);

   /* void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan);
    void cambiarCuenta(int id, EstadoCuenta nuevoEstadoCuenta);*/
}
