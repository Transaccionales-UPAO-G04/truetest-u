package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.CarreraDTO;
import grupo04.truetestu.mapper.CarreraMapper;
import grupo04.truetestu.model.entity.Carrera;
import grupo04.truetestu.repository.CarreraRepository;
import grupo04.truetestu.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    private final CarreraMapper mapper = CarreraMapper.INSTANCE; // Asegúrate de tener el mapper definido

    @Override
    public List<CarreraDTO> obtenerCarreras() {
        return carreraRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarreraDTO crearCarrera(CarreraDTO carreraDTO) {
        Carrera carrera = mapper.toEntity(carreraDTO);
        carrera = carreraRepository.save(carrera);
        return mapper.toDto(carrera);
    }
}
