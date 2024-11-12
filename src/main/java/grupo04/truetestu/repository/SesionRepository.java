package grupo04.truetestu.repository;

import grupo04.truetestu.dto.SesionDTO;
import grupo04.truetestu.model.entity.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface SesionRepository extends JpaRepository<Sesion, Integer> {
    Optional<Object> findByFechaAndTiempo(LocalDate fecha, LocalTime tiempo);
}
