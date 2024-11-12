package grupo04.truetestu.repository;

import grupo04.truetestu.dto.MentorDetailsDTO;
import grupo04.truetestu.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {

    Optional<Mentor> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    boolean existsByNombreAndUsuarioIdNot(String nombre, int usuarioId );

    List<Mentor> findByEspecialidad(String especialidad);

}

    
