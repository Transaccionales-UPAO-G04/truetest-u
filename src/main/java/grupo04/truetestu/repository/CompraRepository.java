package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    List<Compra> findByEstudianteIdEstudiante(int idEstudiante); // Ajuste para acceder correctamente a idEstudiante
}
