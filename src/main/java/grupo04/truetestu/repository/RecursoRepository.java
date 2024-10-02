package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
    List<Recurso> findByEsPremiumFalse();
    List<Recurso> findByEsPremiumTrue();
    List<Recurso> findByEsPremiumFalseAndMentor_IdMentor(int idMentor);
    List<Recurso> findByEsPremiumTrueAndMentor_IdMentor(int idMentor);
}
