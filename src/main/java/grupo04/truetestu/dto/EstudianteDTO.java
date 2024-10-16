package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class EstudianteDTO extends UsuarioDTO {

    private int idEstudiante;

    private EstadoPlan estadoPlan = EstadoPlan.NOPREMIUM;

    private EstadoCuenta estadoCuenta = EstadoCuenta.HABILITADO;

    //Si se quiere incluir, pero puede hacer mas complejo todo
    //Aunque dependerá del contexto
    //private List<PlanDTO> planes;
    //private List<PruebaVocacionalDTO> pruebasVocacionales;
    //private List<ReseñaDTO> reseñas;

}
