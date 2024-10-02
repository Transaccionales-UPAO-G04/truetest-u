package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
    List<Recurso> findByEsPremiumFalse();
    List<Recurso> findByEsPremiumTrue();
    // Métodos para obtener recursos por especialidad del mentor
    @Query("SELECT r FROM Recurso r JOIN r.mentor m WHERE UPPER(m.especialidad) = UPPER(:especialidad) AND r.esPremium = false")
    List<Recurso> obtenerRecursosGratisPorEspecialidad(String especialidad);


    @Query("SELECT r FROM Recurso r JOIN r.mentor m WHERE m.especialidad = :especialidad AND r.esPremium = true")
    List<Recurso> obtenerRecursosPremiumPorEspecialidad(String especialidad);
}
