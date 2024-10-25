package grupo04.truetestu.repository;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.model.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository <Estudiante, Integer> {

    boolean existsByNombre(String nombre);

    boolean existsByNombreAndUsuarioIdNot(String nombre, int usuarioId );

    Optional<EstudianteDTO> findByEmailAndContraseña (String email, String contraseña); //Query de buscar contraseña e email


}