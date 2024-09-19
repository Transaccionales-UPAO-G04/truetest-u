package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {
    List<Mentor> findByEspecialidad(String especialidad);
}

    
