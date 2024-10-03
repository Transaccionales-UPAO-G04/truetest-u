package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisualizarEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
    // Métodos personalizados de consulta, si es necesario.

}

