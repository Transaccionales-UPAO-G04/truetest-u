package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {
    List<Mentor> findByEspecialidad(String especialidad);
}

    
