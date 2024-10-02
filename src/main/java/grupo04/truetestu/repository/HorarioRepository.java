package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    @Modifying
    @Query("DELETE FROM Horario h WHERE h.mentor.idMentor = :mentorId")
    void deleteByMentorId(@Param("mentorId") int mentorId);
}
