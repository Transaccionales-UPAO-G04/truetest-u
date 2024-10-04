package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.HistorialPago;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistorialPagoRepository extends JpaRepository<HistorialPago, Integer> {
    List<HistorialPago> findByEstudiante_IdEstudiante(int idEstudiante);
}
