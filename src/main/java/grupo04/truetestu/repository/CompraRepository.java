package grupo04.truetestu.repository;

import grupo04.truetestu.dto.CompraReportDTO;
import grupo04.truetestu.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
    List<Compra> findByUsuarioId(Integer usuarioId);

    @Query(value = "SELECT precio, consultdate FROM fn_list_pago_report()", nativeQuery = true)
    List<Object[]> getCompraReportByDate();

}