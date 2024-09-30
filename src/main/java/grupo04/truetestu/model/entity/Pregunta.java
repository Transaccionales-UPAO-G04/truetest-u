package grupo04.truetestu.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pregunta")
public class Pregunta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;  // Cambiado a int, para evitar posibles problemas con null

        @Column(nullable = false)
        private String texto;

        @Column(nullable = false)
        private String tipo;

        // Getters y Setters
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getTexto() {
                return texto;
        }

        public void setTexto(String texto) {
                this.texto = texto;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }
}



