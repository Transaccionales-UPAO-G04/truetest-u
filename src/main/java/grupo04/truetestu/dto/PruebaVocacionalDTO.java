package grupo04.truetestu.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import java.util.List;

@Data
public class PruebaVocacionalDTO {

    @Positive(message = "El ID de la prueba vocacional debe ser un número positivo")
    private Long idPruebaVocacional;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    private String descripcion;

    @Valid // Validar cada objeto PreguntaDTO dentro de la lista
    private List<PreguntaDTO> preguntas;
}





