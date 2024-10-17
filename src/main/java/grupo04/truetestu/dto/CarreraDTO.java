package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class CarreraDTO {
    private Long idCarrera;
    private String nombre;
    private String descripcion;
    private int puntuacionRequeridaCiencias;
    private int puntuacionRequeridaArtes;
    private int puntuacionRequeridaHumanidades;
}
