package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.HistorialPago;
import grupo04.truetestu.repository.HistorialPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialPagoService {

    @Autowired
    private HistorialPagoRepository historialPagoRepository;

    public List<HistorialPago> obtenerHistorialPorEstudiante(int idEstudiante) {
        return historialPagoRepository.findByEstudiante_IdEstudiante(idEstudiante);
    }
}
