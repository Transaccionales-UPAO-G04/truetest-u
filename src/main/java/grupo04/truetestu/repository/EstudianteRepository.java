package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    boolean existsEstudianteByEmail(String email);
    Optional<Estudiante> findByEmail(String email); // Cambiar este método
}
