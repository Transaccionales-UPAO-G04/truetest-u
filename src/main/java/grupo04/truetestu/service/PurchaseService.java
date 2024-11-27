package grupo04.truetestu.service;

import grupo04.truetestu.dto.PurchaseCreateUpdateDTO;
import grupo04.truetestu.dto.PurchaseDTO;
import grupo04.truetestu.dto.PurchaseReportDTO;

import java.util.List;

public interface PurchaseService {
    PurchaseDTO createPurchase(PurchaseCreateUpdateDTO purchaseDTO);
    List<PurchaseDTO> getPurchaseHistoryByUserId();
    PurchaseDTO confirmPurchase(Integer purchaseId);


}
