package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Pago;

import java.util.List;

public interface PagoService {
    List<Pago> obtenerTodosLosPagos(); // Método para obtener todos los pagos
    Pago realizarPago(Pago pago); // Método para realizar un pago
    Pago obtenerPagoPorId(int idPago); // Método para obtener un pago por ID
    List<Pago> obtenerPagosPorIdEstudiante(int idEstudiante); // Método para obtener pagos por ID de estudiante
    List<Pago> obtenerPagosPorIdPlan(int idPlan); // Nuevo método para obtener pagos por ID de plan
}
