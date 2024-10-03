package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
    List<Recurso> findByEsPremiumFalse();
    List<Recurso> findByEsPremiumTrue();
    // Métodos para obtener recursos por especialidad del mentor
    List<Recurso> findByEsPremiumAndMentor_Especialidad(boolean esPremium, String especialidad);

}
