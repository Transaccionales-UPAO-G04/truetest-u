package grupo04.truetestu.service.impl;

import grupo04.truetestu.Infra.exception.ResourceNotFoundException;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.EstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;

    @Transactional
    @Override
    public Estudiante registerEstudiante(Estudiante estudiante) {
        if(estudianteRepository.existsEstudianteByEmail(estudiante.getEmail())) {
            throw new RuntimeException("El correo ya fue registrado");
        }

        //falta crear un AT

        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante findById(int id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado"));
    }

    @Override
    public void inhabilitarCuenta(int id) {
        Estudiante estudiante = findById(id);
        estudiante.setEstadoCuenta(EstadoCuenta.INHABILITADO);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan) {
        Estudiante estudiante = findById(id);
        estudiante.setEstadoPlan(nuevoEstadoPlan);
        estudianteRepository.save(estudiante);
    }

}
