package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.HistorialPago;
import grupo04.truetestu.repository.HistorialPagoRepository;
import grupo04.truetestu.service.HistorialPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HistorialPagoServiceImpl implements HistorialPagoService {
    private final HistorialPagoRepository historialPagoRepository;

    @Override
    public List<HistorialPago> obtenerHistorialPorEstudiante(int idEstudiante) {
        return historialPagoRepository.findByEstudiante_IdEstudiante(idEstudiante);
    }

    @Override
    public List<HistorialPago> obtenerTodosLosPagos() {
        return historialPagoRepository.findAll(); // Retorna todos los registros de pagos
    }
}
