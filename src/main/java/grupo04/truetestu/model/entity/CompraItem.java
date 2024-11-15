package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "compra_items")
public class CompraItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float precio;

    @ManyToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "idPlan"
            , foreignKey = @ForeignKey(name = "FK_compra_item_plan"))
    private Plan plan;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "compra_id", referencedColumnName = "id"
            , foreignKey = @ForeignKey(name = "FK_compra_item_compra"))
    public Compra compra;
}
