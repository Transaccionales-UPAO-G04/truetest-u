package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository <Estudiante, Integer> {
    boolean existsEstudianteByEmail(String email);

}