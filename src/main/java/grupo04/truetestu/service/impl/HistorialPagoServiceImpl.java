package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.HistorialPago;
import grupo04.truetestu.repository.HistorialPagoRepository;
import grupo04.truetestu.service.HistorialPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialPagoServiceImpl implements HistorialPagoService {

    @Autowired
    private HistorialPagoRepository historialPagoRepository;

    @Override
    public List<HistorialPago> obtenerHistorialPorEstudiante(int idEstudiante) {
        return historialPagoRepository.findByEstudiante_IdEstudiante(idEstudiante);
    }
}
