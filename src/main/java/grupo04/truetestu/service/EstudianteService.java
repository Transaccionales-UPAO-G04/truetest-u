package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Estudiante;

public interface EstudianteService {

    Estudiante registerEstudiante(Estudiante estudiante);
    Estudiante sesionEstudiante(Estudiante estudiante);

    Estudiante findById(int id);

    Estudiante update(Integer id, Estudiante updateEstudiante);
}
