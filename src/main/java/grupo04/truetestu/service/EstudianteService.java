package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;

import java.util.List;

public interface EstudianteService {

    List<Estudiante> findAll();

    Estudiante registerEstudiante(Estudiante estudiante);

    Estudiante findById(int id);

    Estudiante update(Integer id, Estudiante updateEstudiante);

    Estudiante sesionEstudiante(Estudiante estudiante);

    void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan);

    void cambiarCuenta(int id, EstadoCuenta nuevoEstadoCuenta);

    void changePassword(String email, String currentPassword, String newPassword);

    void sendResetPasswordEmail(String email);
}
