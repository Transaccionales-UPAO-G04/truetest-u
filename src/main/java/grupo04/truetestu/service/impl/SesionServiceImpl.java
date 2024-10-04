package grupo04.truetestu.service.impl;

import grupo04.truetestu.model.entity.Sesion;
import grupo04.truetestu.repository.SesionRepository;
import grupo04.truetestu.service.EstudianteService;
import grupo04.truetestu.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SesionServiceImpl implements SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    @Override
    public Sesion guardarSesion(Sesion sesion) {
        return sesionRepository.save(sesion);  // Guarda la sesión en la base de datos
    }


}