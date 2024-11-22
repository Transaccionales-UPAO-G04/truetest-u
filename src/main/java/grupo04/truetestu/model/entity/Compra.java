package grupo04.truetestu.model.entity;

import grupo04.truetestu.model.enums.EstadoPago;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "compra")
public class Compra {
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
            , foreignKey = @ForeignKey(name = "FK_compra_usuario"))
    private Usuario usuario;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<CompraItem> items;


}