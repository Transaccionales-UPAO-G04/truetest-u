package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {

    // Método existente para encontrar pagos por ID de estudiante
    List<Pago> findByEstudiante_IdEstudiante(int idEstudiante);

    // Nuevo método para encontrar pagos por ID de plan
    List<Pago> findByPlan_IdPlan(int idPlan);

    // Método para obtener el reporte de pagos por fecha
    @Query("SELECT p FROM Pago p WHERE p.createdAt = :date")
    List<Pago> getPagoReportByDate(LocalDateTime date);
}
