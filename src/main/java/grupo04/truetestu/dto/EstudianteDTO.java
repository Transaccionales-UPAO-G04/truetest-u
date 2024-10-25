package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import lombok.Data;

@Data
public class EstudianteDTO extends UsuarioDTO {

    private int idEstudiante;

    private EstadoPlan estadoPlan = EstadoPlan.NOPREMIUM;

    private EstadoCuenta estadoCuenta = EstadoCuenta.HABILITADO;
}


