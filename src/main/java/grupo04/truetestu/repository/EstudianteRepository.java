package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    // Método para verificar si un estudiante ya existe por correo
    boolean existsEstudianteByEmail(String email);

    // Método para encontrar un estudiante por su correo
    Optional<Estudiante> findByEmail(String email);
}
