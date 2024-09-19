package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.ResultadoPrueba;
import java.util.List;

public interface ResultadoPruebaService {
    ResultadoPrueba create(ResultadoPrueba resultadoPrueba);
    ResultadoPrueba findByID(Integer id);
    List<ResultadoPrueba> getAll();
    ResultadoPrueba update(Integer id, ResultadoPrueba resultadoPrueba);
    void delete(Integer id);
}
