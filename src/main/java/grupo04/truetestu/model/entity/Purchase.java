package grupo04.truetestu.model.entity;

import grupo04.truetestu.model.enums.EstadoPago;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float Monto;    
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago")
    private EstadoPago estadoPago;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id"
            , foreignKey = @ForeignKey(name = "FK_purchase_usuario"))
    private Usuario usuario;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<PurchaseItem> items;


}