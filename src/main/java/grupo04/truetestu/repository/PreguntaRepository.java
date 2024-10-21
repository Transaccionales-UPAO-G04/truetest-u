package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    List<Pregunta> findByPruebaVocacional_IdPruebaVocacional(Long idPruebaVocacional);
}
