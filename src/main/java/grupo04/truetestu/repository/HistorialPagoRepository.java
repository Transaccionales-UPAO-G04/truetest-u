package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.HistorialPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialPagoRepository extends JpaRepository<HistorialPago, Integer> {
    List<HistorialPago> findByEstudiante_IdEstudiante(int idEstudiante);
}
