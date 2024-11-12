package grupo04.truetestu.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/historial-pagos")
@PreAuthorize("hasAnyRole('ESTUDIANTE')")
public class HistorialPagoController {/*

    @Autowired
    private HistorialPagoService historialPagoService;

    // Endpoint para obtener el historial de pagos de un estudiante
    @Operation(summary = "Obtener historial de pagos por estudiante",
            description = "Devuelve una lista del historial de pagos de un estudiante dado su ID.")
    @GetMapping("/{idEstudiante}")
    public List<HistorialPago> obtenerHistorialDePagos(@PathVariable int idEstudiante) {
        return historialPagoService.obtenerHistorialPorEstudiante(idEstudiante);
    }*/
}
