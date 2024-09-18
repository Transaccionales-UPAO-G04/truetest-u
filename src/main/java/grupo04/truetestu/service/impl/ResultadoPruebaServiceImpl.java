package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.repository.ResultadoPruebaRepository;
import grupo04.truetestu.service.ResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service
public class ResultadoPruebaServiceImpl implements ResultadoPruebaService {

    private final ResultadoPruebaRepository resultadoPruebaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ResultadoPrueba> getAll() {
        return resultadoPruebaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ResultadoPrueba> paginate(Pageable pageable) {
        return resultadoPruebaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ResultadoPrueba> findByEstudianteId(int id) {
        // Aquí necesitas implementar la consulta para obtener el resultado basado en el ID del estudiante
        // Puedes necesitar modificar el repositorio para incluir una consulta personalizada
        return resultadoPruebaRepository.findByEstudianteId(id);
    }
}
