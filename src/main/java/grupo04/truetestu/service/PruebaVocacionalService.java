package grupo04.truetestu.service;

import grupo04.truetestu.dto.PruebaVocacionalDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PruebaVocacionalService {

    PruebaVocacionalDTO create(PruebaVocacionalDTO pruebaVocacionalDto);
    List<PruebaVocacionalDTO> getAll();
    Optional<PruebaVocacionalDTO> findByID(Integer id);
    Optional<PruebaVocacionalDTO> update(Integer id, PruebaVocacionalDTO pruebaVocacionalDto);
    void delete(Integer id);
}

