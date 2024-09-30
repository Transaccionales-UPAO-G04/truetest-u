package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultadoPruebaRepository extends JpaRepository<ResultadoPrueba, Integer> {
    @Query("SELECT r FROM ResultadoPrueba r WHERE r.pruebaVocacional.estudiante.idEstudiante = :id")
    Optional<ResultadoPrueba> findByEstudianteId(@Param("id") int id);
}

