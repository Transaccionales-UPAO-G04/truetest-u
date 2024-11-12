package grupo04.truetestu.service;

import grupo04.truetestu.dto.ResultadoPruebaDTO;

import java.util.List;

public interface ResultadoPruebaService {
    List<ResultadoPruebaDTO> obtenerResultados();  // Asegúrate de que este método exista
    ResultadoPruebaDTO crearResultadoPrueba(ResultadoPruebaDTO resultadoPruebaDTO);
}
