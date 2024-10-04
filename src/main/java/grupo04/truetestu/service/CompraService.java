package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Compra;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Plan;

import java.util.List;

public interface CompraService {
    Compra registrarCompra(Estudiante estudiante, Plan plan, String metodoPago);
    List<Compra> obtenerComprasPorEstudiante(int idEstudiante); // Método que mencionaste en el error
}
