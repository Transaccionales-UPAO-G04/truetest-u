package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Estudiante;
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

        // Aquí puedes agregar lógica adicional, como encriptar la contraseña
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante sesionEstudiante(Estudiante estudiante) {
        Estudiante estudianteExistente = estudianteRepository.findByEmailAndContraseña(estudiante.getEmail(), estudiante.getContraseña());
        if(estudianteExistente != null) {
            return estudianteExistente;
        } else {
            throw new RuntimeException("ERROR: Correo o contraseña incorrectos");
        }
    }
}
