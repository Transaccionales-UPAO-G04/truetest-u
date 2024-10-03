package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    // Otros métodos personalizados, si es necesario.
}


