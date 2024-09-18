package grupo04.truetestu.service.impl;


import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    @Transactional(readOnly = true)
    @Override
    public Estudiante findById(int id) {
        return estudianteRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Category not found"));
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



}
