package grupo04.truetestu.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class SesionDTO {



    private int idSesion;

    @NotBlank(message = "La hora es obligatorio")
    private LocalTime tiempo;
    @NotBlank(message = "La fecha es obligatoria")
    private LocalDate fecha;

    private String linkSesionPrivada;
}
