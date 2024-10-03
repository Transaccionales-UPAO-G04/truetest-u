package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Recurso;

import java.util.List;
import java.util.Optional;

public interface RecursoService {
    List<Recurso> obtenerTodos();
    Optional<Recurso> obtenerPorId(int id);
    Recurso guardar(Recurso recurso);
    void eliminar(int id);

    List<Recurso> obtenerRecursosGratis();
    List<Recurso> obtenerRecursosPremium();

    List<Recurso> obtenerRecursosPremiumPorEspecialidad(String especialidad);
    List<Recurso> obtenerRecursosGratisPorEspecialidad(String especialidad);

    Recurso cambiarEstadoFavorito(int recursoId);
}
