package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Pago;
import grupo04.truetestu.repository.PagoRepository;
import grupo04.truetestu.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;

    @Override
    public List<Pago> obtenerTodosLosPagos() {
        return pagoRepository.findAll(); // Retorna todos los pagos
    }

    @Override
    public Pago realizarPago(Pago pago) {
        return pagoRepository.save(pago); // Guarda el pago en la base de datos
    }

    @Override
    public Pago obtenerPagoPorId(int idPago) {
        return pagoRepository.findById(idPago)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado")); // Lanza una excepción si no se encuentra el pago
    }

    @Override
    public List<Pago> obtenerPagosPorIdEstudiante(int idEstudiante) {
        return pagoRepository.findByEstudiante_IdEstudiante(idEstudiante); // Retorna pagos por ID de estudiante
    }

    @Override
    public List<Pago> obtenerPagosPorIdPlan(int idPlan) {
        return pagoRepository.findByPlan_IdPlan(idPlan); // Retorna pagos por ID de plan
    }
}

