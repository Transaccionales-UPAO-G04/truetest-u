package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.EstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;
    private final PasswordEncoder passwordEncoder; // Agregar esto

    @Transactional
    @Override
    public Estudiante registerEstudiante(Estudiante estudiante) {
        if (estudianteRepository.existsEstudianteByEmail(estudiante.getEmail())) {
            throw new RuntimeException("El correo ya fue registrado");
        }

        // Encriptar la contraseña antes de guardar
        estudiante.setContraseña(passwordEncoder.encode(estudiante.getContraseña()));

        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante sesionEstudiante(Estudiante estudiante) {
        Estudiante estudianteExistente = estudianteRepository.findByEmail(estudiante.getEmail())
                .orElseThrow(() -> new RuntimeException("ERROR: Correo o contraseña incorrectos"));

        // Verificar la contraseña encriptada
        if (!passwordEncoder.matches(estudiante.getContraseña(), estudianteExistente.getContraseña())) {
            throw new RuntimeException("ERROR: Correo o contraseña incorrectos");
        }

        return estudianteExistente;
    }

    @Transactional
    @Override
    public Estudiante update(Integer id, Estudiante updateEstudiante) {
        Estudiante estudianteFromDb = findById(id);
        estudianteFromDb.setNombreEstudiante(updateEstudiante.getNombreEstudiante());
        estudianteFromDb.setEmail(updateEstudiante.getEmail());

        // Si se actualiza la contraseña, encriptarla
        if (updateEstudiante.getContraseña() != null) {
            estudianteFromDb.setContraseña(passwordEncoder.encode(updateEstudiante.getContraseña()));
        }

        return estudianteRepository.save(estudianteFromDb);
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
    @Override
    public Estudiante findById(int id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

}
