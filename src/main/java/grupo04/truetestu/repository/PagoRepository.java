package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByEstudiante_IdEstudiante(int idEstudiante); // Método existente

    // Nuevo método para encontrar pagos por ID de plan
    List<Pago> findByPlan_IdPlan(int idPlan);
}
