package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.EstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Instancia de BCrypt

    // Otros métodos existentes...

    @Override
    public void inhabilitarCuenta(int id) {
        Estudiante estudiante = findById(id); // Encuentra al estudiante
        estudiante.setEstadoCuenta(EstadoCuenta.INHABILITADO); // Cambia el estado de cuenta
        estudianteRepository.save(estudiante); // Guarda los cambios
    }

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

        // Si se actualiza la contraseña, encriptarla antes de guardar
        if (updateEstudiante.getContraseña() != null && !updateEstudiante.getContraseña().isEmpty()) {
            estudianteFromDb.setContraseña(passwordEncoder.encode(updateEstudiante.getContraseña()));
        }

        return estudianteRepository.save(estudianteFromDb);
    }

    @Override
    public Estudiante sesionEstudiante(Estudiante estudiante) {
        // Buscar al estudiante por correo electrónico y lanzar excepción si no se encuentra
        Estudiante estudianteExistente = estudianteRepository.findByEmail(estudiante.getEmail())
                .orElseThrow(() -> new RuntimeException("ERROR: Correo o contraseña incorrectos"));

        // Verificar si la contraseña proporcionada coincide con la almacenada
        if (passwordEncoder.matches(estudiante.getContraseña(), estudianteExistente.getContraseña())) {
            return estudianteExistente;
        } else {
            throw new RuntimeException("ERROR: Correo o contraseña incorrectos");
        }
    }

    @Transactional
    @Override
    public void changePassword(String email, String currentPassword, String newPassword) {
        // Buscar el estudiante por correo electrónico
        Estudiante estudiante = estudianteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Correo no encontrado"));

        // Verificar si la contraseña actual coincide con la almacenada
        if (!passwordEncoder.matches(currentPassword, estudiante.getContraseña())) {
            throw new RuntimeException("La contraseña actual es incorrecta.");
        }

        // Encriptar la nueva contraseña y guardarla
        estudiante.setContraseña(passwordEncoder.encode(newPassword));
        estudianteRepository.save(estudiante);
    }

    @Override
    public void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan) {
        Estudiante estudiante = findById(id);
        estudiante.setEstadoPlan(nuevoEstadoPlan);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void cambiarCuenta(int id, EstadoCuenta nuevoEstadoCuenta) {
        Estudiante estudiante = findById(id);
        estudiante.setEstadoCuenta(nuevoEstadoCuenta);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void sendResetPasswordEmail(String email) {
        Estudiante estudiante = estudianteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Correo no encontrado"));

        String resetLink = "http://localhost:8080/auth/reset-password?email=" + email;
        System.out.println("Correo de restablecimiento de contraseña enviado a: " + email);
        System.out.println("Enlace de restablecimiento: " + resetLink);
    }

}
