package grupo04.truetestu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity

public class PruebaVocacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "nro_prueba", nullable = false) //length=longitud, si es string se convertirá a varchar, por ejemplo
    private int nroPrueba;

    @Column(name= "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name= "descripcion_prueba", nullable = false, columnDefinition = "TEXT")
    private String descripcionPrueba;

}
