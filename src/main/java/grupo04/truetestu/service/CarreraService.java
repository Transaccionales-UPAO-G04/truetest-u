package grupo04.truetestu.service;

import grupo04.truetestu.dto.CarreraDTO;

import java.util.List;

public interface CarreraService {
    List<CarreraDTO> obtenerCarreras();
    CarreraDTO crearCarrera(CarreraDTO carreraDTO);
}


