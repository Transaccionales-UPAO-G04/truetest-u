package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class PagoCaptureResponse {
    private boolean completed;
    private Integer purchaseId;
}
