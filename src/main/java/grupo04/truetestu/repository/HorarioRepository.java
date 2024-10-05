package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Horario;
import grupo04.truetestu.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    // Método para eliminar horarios por mentor
    void deleteByMentor(Mentor mentor);
}


