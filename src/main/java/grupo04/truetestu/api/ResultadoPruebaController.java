package grupo04.truetestu.api;

import grupo04.truetestu.dto.ResultadoPruebaDTO;
import grupo04.truetestu.service.ResultadoPruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultado-prueba")
public class ResultadoPruebaController {

    @Autowired
    private ResultadoPruebaService resultadoPruebaService;

    @GetMapping
    public List<ResultadoPruebaDTO> obtenerResultados() {
        return resultadoPruebaService.obtenerResultados();
    }

    @PostMapping
    public ResultadoPruebaDTO crearResultadoPrueba(@RequestBody ResultadoPruebaDTO resultadoPruebaDTO) {
        return resultadoPruebaService.crearResultadoPrueba(resultadoPruebaDTO);
    }
}

