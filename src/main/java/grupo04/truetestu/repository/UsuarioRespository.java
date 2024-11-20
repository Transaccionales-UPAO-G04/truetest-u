package grupo04.truetestu.repository;

import grupo04.truetestu.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRespository extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email); //QUERY de si existe el usuario
}
