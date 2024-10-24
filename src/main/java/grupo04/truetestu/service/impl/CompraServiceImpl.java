package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Compra;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.repository.CompraRepository;
import grupo04.truetestu.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public Compra registrarCompra(Estudiante estudiante, Plan plan, String metodoPago) {
        Compra compra = new Compra();
        compra.setEstudiante(estudiante);
        compra.setPlan(plan);
        compra.setMetodoPago(metodoPago);
        compra.setEstado("completado"); // Ejemplo de estado
        return compraRepository.save(compra); // Retorna la compra guardada
    }

    @Override
    public List<Compra> obtenerComprasPorEstudiante(int idEstudiante) {
        return compraRepository.findByEstudianteIdEstudiante(idEstudiante); // Implementa el método faltante
    }
}