package grupo04.truetestu.service;

import grupo04.truetestu.dto.CompraCreateUpdateDTO;
import grupo04.truetestu.dto.CompraDTO;
import grupo04.truetestu.dto.CompraReportDTO;

import java.util.List;

public interface CompraService {
    CompraDTO createCompra(CompraCreateUpdateDTO compraDTO);

    List<CompraReportDTO> getCompraReportByDate();
    List<CompraDTO> getCompraHistoryByUsuarioId();

    List<CompraDTO> getAllCompras();
    CompraDTO confirmCompra(Integer CompraId);
    CompraDTO getCompraById(Integer id);


}
