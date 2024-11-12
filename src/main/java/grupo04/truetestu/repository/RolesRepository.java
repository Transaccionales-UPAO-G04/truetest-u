package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Roles;
import grupo04.truetestu.model.enums.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(TipoUsuario name);
}
