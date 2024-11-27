package grupo04.truetestu.service;
import grupo04.truetestu.dto.ReseñaDTO;
import grupo04.truetestu.model.entity.Reseña;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ReseñaService {


    List<ReseñaDTO> findAll();
    ReseñaDTO findById(int id);
    ReseñaDTO createReseña(int idMentor,int idEstudiante,ReseñaDTO reseña);

    //listar reseñas segun el mentor
    List<ReseñaDTO> findByMentorId(int idMentor);

    @Transactional
    void delete(int id);

}
