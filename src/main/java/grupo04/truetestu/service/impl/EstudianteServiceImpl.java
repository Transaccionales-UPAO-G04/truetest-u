package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.EstudianteDTO; // Importa el DTO
import grupo04.truetestu.mapper.EstudianteMapper; // Importa el mapper
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.EstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final PasswordEncoder passwordEncoder;
    private final EstudianteMapper estudianteMapper; // Agrega el mapper aquí

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante findById(int id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

    @Transactional
    @Override
    public Estudiante registerEstudiante(Estudiante estudiante) {
        if (estudianteRepository.existsEstudianteByEmail(estudiante.getEmail())) {
            throw new RuntimeException("El correo ya fue registrado");
        }

        estudiante.setContraseña(passwordEncoder.encode(estudiante.getContraseña()));
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante sesionEstudiante(Estudiante estudiante) {
        Estudiante estudianteExistente = estudianteRepository.findByEmail(estudiante.getEmail())
                .orElseThrow(() -> new RuntimeException("ERROR: Correo o contraseña incorrectos"));

        if (!passwordEncoder.matches(estudiante.getContraseña(), estudianteExistente.getContraseña())) {
            throw new RuntimeException("ERROR: Correo o contraseña incorrectos");
        }

        return estudianteExistente;
    }

    @Transactional
    @Override
    public EstudianteDTO update(Integer id, EstudianteDTO updateEstudianteDTO) {
        Estudiante estudianteFromDb = findById(id);
        estudianteFromDb.setNombreEstudiante(updateEstudianteDTO.getNombreEstudiante());
        estudianteFromDb.setEmail(updateEstudianteDTO.getEmail());

        if (updateEstudianteDTO.getContraseña() != null) {
            estudianteFromDb.setContraseña(passwordEncoder.encode(updateEstudianteDTO.getContraseña()));
        }

        estudianteRepository.save(estudianteFromDb);
        return estudianteMapper.toDTO(estudianteFromDb);
    }

    @Transactional
    @Override
    public void inhabilitarCuenta(int id) {
        Estudiante estudiante = findById(id);
        estudiante.setEstadoCuenta(EstadoCuenta.INHABILITADO);
        estudianteRepository.save(estudiante);
    }

    @Transactional
    @Override
    public void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan) {
        Estudiante estudiante = findById(id);
        estudiante.setEstadoPlan(nuevoEstadoPlan);
        estudianteRepository.save(estudiante);
    }

    @Transactional
    @Override
    public void cambiarCuenta(int id, EstadoCuenta nuevoEstado) {
        Estudiante estudiante = findById(id);
        estudiante.setEstadoCuenta(nuevoEstado);
        estudianteRepository.save(estudiante);
    }
}


