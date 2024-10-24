package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.HistorialPago;

import java.util.List;

public interface HistorialPagoService {
    List<HistorialPago> obtenerHistorialPorEstudiante(int idEstudiante);
    List<HistorialPago> obtenerTodosLosPagos();
}
