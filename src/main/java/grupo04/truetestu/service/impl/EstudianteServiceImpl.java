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
        if (estudianteRepository.existsEstudianteByEmail(estudiante.getEmail())) {
            throw new RuntimeException("El correo ya fue registrado");
        }

        //falta crear un AT

        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante findById(int id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Transactional
    @Override
    public Estudiante update(Integer id, Estudiante updateEstudiante) {
        Estudiante estudianteFromDb = findById(id);
        estudianteFromDb.setNombreEstudiante(updateEstudiante.getNombreEstudiante());
        estudianteFromDb.setEmail(updateEstudiante.getEmail());
        estudianteFromDb.setContraseña(updateEstudiante.getContraseña());
        return estudianteRepository.save(estudianteFromDb);
    }

    @Override
    public Estudiante sesionEstudiante(Estudiante estudiante) {
        Estudiante estudianteExistente = estudianteRepository.findByEmailAndContraseña(estudiante.getEmail(), estudiante.getContraseña());
        if (estudianteExistente != null) {
            return estudianteExistente;
        } else {
            throw new RuntimeException("ERROR: Correo o contraseña incorrectos");
        }
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
