package grupo04.truetestu.api;

import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<RespuestaDTO> obtenerRespuestas() {
        return respuestaService.obtenerRespuestas();
    }

    @PostMapping
    public RespuestaDTO crearRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
        return respuestaService.crearRespuesta(respuestaDTO);
    }
}

