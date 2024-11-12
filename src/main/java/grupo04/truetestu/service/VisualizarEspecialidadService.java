package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.Especialidad;
import java.util.List;

public interface VisualizarEspecialidadService {
    Especialidad findByID(Integer id);
    List<Especialidad> getAll();
}

