package grupo04.truetestu.repository;

import grupo04.truetestu.dto.ReseñaDTO;
import grupo04.truetestu.model.entity.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReseñaRepository extends JpaRepository <Reseña, Integer> {

    List<Reseña> findAllByMentor_IdMentor(int idMentor);
}
