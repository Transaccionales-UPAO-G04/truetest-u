package grupo04.truetestu.api;

import grupo04.truetestu.dto.CarreraDTO;
import grupo04.truetestu.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<CarreraDTO> obtenerCarreras() {
        return carreraService.obtenerCarreras();
    }

    @PostMapping
    public CarreraDTO crearCarrera(@RequestBody CarreraDTO carreraDTO) {
        return carreraService.crearCarrera(carreraDTO);
    }
}


