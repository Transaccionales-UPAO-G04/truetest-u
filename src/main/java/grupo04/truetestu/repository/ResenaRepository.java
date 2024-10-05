package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Resena; // Asegúrate de que el import sea correcto
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Integer> {
    // Métodos personalizados, si es necesario
}
