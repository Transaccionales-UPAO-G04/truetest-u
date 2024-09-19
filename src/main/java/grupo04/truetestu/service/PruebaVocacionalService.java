package grupo04.truetestu.service;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.model.entity.PruebaVocacional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PruebaVocacionalService {
    List<PruebaVocacionalDTO> getAll();
    Page<PruebaVocacionalDTO> paginate(Pageable pageable);
    PruebaVocacionalDTO create(PruebaVocacionalDTO pruebaVocacionalDTO);
    Optional<PruebaVocacionalDTO> findByID(Integer id);
    Optional<PruebaVocacionalDTO> update(Integer id, PruebaVocacionalDTO pruebaVocacionalDTO);
    void delete(Integer id);
}
