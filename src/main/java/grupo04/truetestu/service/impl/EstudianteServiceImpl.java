package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Usuario;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.EstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;



@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }


    @Transactional
    @Override
    public Estudiante registerEstudiante(Estudiante estudiante) {/*
        if (estudianteRepository.existsEstudianteByEmail(Usuario.getEmail())) {
            throw new RuntimeException("El correo ya fue registrado");
        }*/

        // Falta crear un AT
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
        return estudianteRepository.save(estudianteFromDb);
    }

    //PUESTO DE MOMENTO
    @Override
    public Estudiante sesionEstudiante(Estudiante estudiante) {
        return null;
    }
/*
    @Override
    public Estudiante sesionEstudiante(Estudiante estudiante, Usuario usuario) {
        Estudiante estudianteExistente = estudianteRepository.findByEmailAndContraseña(Usuario.getEmail(), Usuario.getContraseña());
        if (estudianteExistente != null) {
            return estudianteExistente;
        } else {
            throw new RuntimeException("ERROR: Correo o contraseña incorrectos");
        }
    }*/

    @Override
    public void cambiarPlan(int id, EstadoPlan nuevoEstadoPlan) { //iniciar sesion
        Estudiante estudiante = findById(id);
        estudiante.setEstadoPlan(nuevoEstadoPlan);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void cambiarCuenta(int id, EstadoCuenta nuevoEstadoCuenta) { //iniciar sesion
        Estudiante estudiante = findById(id);
        estudiante.setEstadoCuenta(nuevoEstadoCuenta);
        estudianteRepository.save(estudiante);
    }


}

