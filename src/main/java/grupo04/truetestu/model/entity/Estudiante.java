package grupo04.truetestu.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;


    @Enumerated(EnumType.STRING)
    @Column(name = "estado_plan", nullable = false)
    private EstadoPlan estadoPlan = EstadoPlan.NOPREMIUM;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_Cuenta", nullable = false)
    private EstadoCuenta estadoCuenta = EstadoCuenta.HABILITADO;


    @JsonIgnore
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plan> planes;

    @JsonIgnore
    @OneToMany (mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PruebaVocacional> pruebasVocacionales;  // Agregado para cascada

    @JsonIgnore
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reseña> reseñas;



}