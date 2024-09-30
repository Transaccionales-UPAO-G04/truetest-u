package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Mentor;
import java.util.List;

public interface MentorService {
    List<Mentor> findAll();
    Mentor findById(int id);
    List<Mentor> findByEspecialidad(String especialidad);
    Mentor createMentor(Mentor mentor);
    Mentor updateMentor(int id, Mentor mentor);
    void deleteMentor(int id);

    // Nuevos métodos para recomendaciones
    List<Mentor> recomendarMentoresPorEspecialidad(String especialidad, int minExperiencia, int maxExperiencia);
}
