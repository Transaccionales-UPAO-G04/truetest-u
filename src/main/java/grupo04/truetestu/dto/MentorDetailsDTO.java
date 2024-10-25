package grupo04.truetestu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MentorDetailsDTO {
    private int idMentor;

    private String nombre;
    private String experiencia;
    private String especialidad;
    private String linkRecurso;
    private String linkRecursoPremium;
    private String idReseña;
    private String idHorario;

}
