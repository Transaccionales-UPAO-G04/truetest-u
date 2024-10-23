package grupo04.truetestu.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
public class CarreraDTO {

    @Positive(message = "El ID de la carrera debe ser un número positivo")
    private Long idCarrera;

    @NotBlank(message = "El nombre de la carrera es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre de la carrera debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción de la carrera es obligatoria")
    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    private String descripcion;

    @Positive(message = "La puntuación requerida en Ciencias debe ser un número positivo")
    private int puntuacionRequeridaCiencias;

    @Positive(message = "La puntuación requerida en Artes debe ser un número positivo")
    private int puntuacionRequeridaArtes;

    @Positive(message = "La puntuación requerida en Humanidades debe ser un número positivo")
    private int puntuacionRequeridaHumanidades;
}

