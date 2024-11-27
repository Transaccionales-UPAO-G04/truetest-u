package grupo04.truetestu.repository;

import grupo04.truetestu.dto.PurchaseReportDTO;
import grupo04.truetestu.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    List<Purchase> findByUsuarioId(Integer usuarioId);

   // Optional<Purchase> findByIdAndEstadoPago(Integer id, EstadoPago estadoPago);

   // @Query(value = "SELECT  private quantity;, consultdate FROM fn_list_pago_report()", nativeQuery = true)
    // List<Object[]> getPurchaseReportByDate();

}