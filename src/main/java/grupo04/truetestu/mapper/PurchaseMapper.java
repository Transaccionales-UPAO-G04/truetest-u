//Correguir el final que trata sobre de book
package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.PurchaseCreateUpdateDTO;
import grupo04.truetestu.dto.PurchaseDTO;
import grupo04.truetestu.dto.PurchaseItemCreateUpdateDTO;
import grupo04.truetestu.dto.PurchaseItemDTO;
import grupo04.truetestu.model.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    private final ModelMapper modelMapper;

    public PurchaseMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    //Convertir purchaseCreateUpdateDTO a purchasea (Crear una purchase)
    public Purchase toPurchaseEntity(PurchaseCreateUpdateDTO purchaseDTO) {
        Purchase purchase = modelMapper.map(purchaseDTO, Purchase.class);

        Usuario usuario = new Usuario();
        usuario.setId(purchaseDTO.getEstudianteId());
        purchase.setUsuario(usuario);

        //Mapear manualmente los items de la purchase
        purchase.setItems(purchaseDTO.getItems().stream()
                .map(this::toPurchaseItemEntity)
                .toList());

        return purchase;
    }

    //Convertir Purchase a PurchaseDTO (Mostrar una compra)
    public PurchaseDTO toPurchaseDTO(Purchase purchase) {
        PurchaseDTO purchaseDTO = modelMapper.map(purchase, PurchaseDTO.class);

        purchaseDTO.setItems(purchase.getItems().stream()
                .map(this::toPurchaseItemDTO)
                .toList());
        return purchaseDTO;
    }

    private PurchaseItem toPurchaseItemEntity(PurchaseItemCreateUpdateDTO itemDTO) {
        PurchaseItem item = modelMapper.map(itemDTO, PurchaseItem.class);
        Plan plan = new Plan();
        plan.setIdPlan(itemDTO.getIdPlan());
        item.setPlan(plan);
        return item;
    }

    private PurchaseItemDTO toPurchaseItemDTO(PurchaseItem item) {
        PurchaseItemDTO itemDTO = modelMapper.map(item, PurchaseItemDTO.class);
        itemDTO.setNombrePlan(item.getPlan().getNombre());
        return itemDTO;
    }

}
