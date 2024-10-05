package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;

public interface EstudianteService {

    Estudiante registerEstudiante(Estudiante estudiante);
    Estudiante sesionEstudiante(Estudiante estudiante);
    Estudiante findById(int id);
    void inhabilitarCuenta(int id);
    void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan);
    Estudiante update(Integer id, Estudiante updateEstudiante);

    // Método para cambiar la contraseña
    void changePassword(String email, String currentPassword, String newPassword);

    // Métodos adicionales para cambiar el estado de la cuenta y enviar correos de restablecimiento de contraseña
    void cambiarCuenta(int id, EstadoCuenta nuevoEstadoCuenta);  // Método para cambiar el estado de la cuenta
    void sendResetPasswordEmail(String email);  // Método para enviar un correo de restablecimiento de contraseña
}



