package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Pago;
import grupo04.truetestu.repository.PagoRepository;
import grupo04.truetestu.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public Pago realizarPago(Pago pago) {
        return pagoRepository.save(pago);
    }
}
