package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Sesion;
import grupo04.truetestu.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Integer> {

    // Método para eliminar sesiones por mentor
    void deleteByMentor(Mentor mentor);
}

