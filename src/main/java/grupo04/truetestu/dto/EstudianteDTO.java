package grupo04.truetestu.dto;

import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import lombok.Data;

@Data
public class EstudianteDTO {
    private PlanDTO plan; // Si quieres traer el objeto completo
    private String nombre;  // Nombre del estudiante
    private String Email;  // Correo electrónico del estudiante
    private EstadoCuenta estadoCuenta;  // Estado de la cuenta, por ejemplo, "ACTIVO", "INACTIVO"
    private EstadoPlan estadoPlan;  // Estado del plan, como "ACTIVO", "INACTIVO"


    // Getters y Setters
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    // Aquí se podrían incluir las listas de otros DTOs si fueran necesarios
    // private List<PlanDTO> planes;
    // private List<PruebaVocacionalDTO> pruebasVocacionales;
    // private List<ReseñaDTO> reseñas;
}
