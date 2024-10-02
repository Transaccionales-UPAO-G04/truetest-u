package grupo04.truetestu.api;

import grupo04.truetestu.model.entity.HistorialPago;
import grupo04.truetestu.service.impl.HistorialPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/historial-pagos")
public class HistorialPagoController {

    @Autowired
    private HistorialPagoService historialPagoService;

    // Endpoint para obtener el historial de pagos de un estudiante
    @GetMapping("/{idEstudiante}")
    public List<HistorialPago> obtenerHistorialDePagos(@PathVariable int idEstudiante) {
        return historialPagoService.obtenerHistorialPorEstudiante(idEstudiante);
    }
}
