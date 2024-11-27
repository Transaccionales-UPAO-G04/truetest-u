package grupo04.truetestu.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PurchaseCreateUpdateDTO {

    private Float total;

    //private EstudianteDTO estudiante;

    private Integer estudianteId;

    private List<PurchaseItemCreateUpdateDTO> items;


}
