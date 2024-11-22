package grupo04.truetestu.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {

    private String token;         // El token JWT
    private String nombre;     // El primer nombre del usuario
    private String role;          // El rol del usuario (e.g., ROLE_CUSTOMER, ROLE_AUTHOR)
}