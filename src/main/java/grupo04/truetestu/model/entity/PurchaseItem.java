package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "purchase_items")
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float precio;

    @ManyToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "idPlan"
            , foreignKey = @ForeignKey(name = "FK_purchase_item_plan"))
    private Plan plan;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id"
            , foreignKey = @ForeignKey(name = "FK_purchase_item_purchase"))
    public Purchase purchase;
}
