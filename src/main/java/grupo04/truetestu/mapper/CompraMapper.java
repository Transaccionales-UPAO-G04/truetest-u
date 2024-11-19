//Correguir el final que trata sobre de book
package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.CompraCreateUpdateDTO;
import grupo04.truetestu.dto.CompraDTO;
import grupo04.truetestu.dto.CompraItemCreateUpdateDTO;
import grupo04.truetestu.dto.CompraItemDTO;
import grupo04.truetestu.model.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {

    private final ModelMapper modelMapper;

    public CompraMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    //Convertir CompraCreateUpdateDTO a Compra (Crear una compra)
    public Compra toCompraEntity(CompraCreateUpdateDTO compraDTO) {
        Compra compra = modelMapper.map(compraDTO, Compra.class);

        Usuario usuario = new Usuario();
        usuario.setId(compraDTO.getEstudianteId());
        compra.setUsuario(usuario);

        //Mapear manualmente los items de la compra
        compra.setItems(compraDTO.getItems().stream()
                .map(this::toCompraItemEntity)
                .toList());

        return compra;
    }

    //Convertir Compra a CompraDTO (Mostrar una compra)
    public CompraDTO toCompraDTO(Compra compra) {
        CompraDTO compraDTO = modelMapper.map(compra, CompraDTO.class);

        compraDTO.setItems(compra.getItems().stream()
                .map(this::toCompraItemDTO)
                .toList());
        return compraDTO;
    }

    private CompraItem toCompraItemEntity(CompraItemCreateUpdateDTO itemDTO) {
        CompraItem item = modelMapper.map(itemDTO, CompraItem.class);
        Plan plan = new Plan();
        plan.setIdPlan(itemDTO.getIdPlan());
        item.setPlan(plan);
        return item;
    }

    private CompraItemDTO toCompraItemDTO(CompraItem item) {
        CompraItemDTO itemDTO = modelMapper.map(item, CompraItemDTO.class);
        itemDTO.setNombrePlan(item.getPlan().getNombre());
        return itemDTO;
    }

}
