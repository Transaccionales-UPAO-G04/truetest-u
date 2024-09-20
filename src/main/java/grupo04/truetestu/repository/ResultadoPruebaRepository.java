package grupo04.truetestu.repository;

<<<<<<< HEAD

import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ResultadoPruebaRepository extends JpaRepository<ResultadoPrueba, Integer> {
    @Query("SELECT r FROM ResultadoPrueba r WHERE r.pruebaVocacional.estudiante.idEstudiante = :id")
    Optional<ResultadoPrueba> findByEstudianteId(@Param("id") int id);
=======
import grupo04.truetestu.model.entity.ResultadoPrueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoPruebaRepository extends JpaRepository<ResultadoPrueba, Integer> {
    // Métodos personalizados de consulta, si es necesario.
>>>>>>> feature/ResultadoPrueba
}
