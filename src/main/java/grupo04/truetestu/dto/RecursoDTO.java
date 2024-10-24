package grupo04.truetestu.dto;


import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class RecursoDTO {
    private int idRecurso;

    @NotBlank(message = "El link no tiene que estar en blanco")
    private String linkRecurso;

    private boolean esPremium;

}
