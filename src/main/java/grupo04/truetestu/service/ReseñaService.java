package grupo04.truetestu.service;
import grupo04.truetestu.model.entity.Reseña;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ReseñaService {
    List<Reseña> findAll();
    Reseña findById(int id);
    Reseña createReseña(Reseña reseña);
    Reseña update(int id, Reseña reseña);
    @Transactional
    void delete(int id);
}
