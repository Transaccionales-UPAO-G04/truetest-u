package grupo04.truetestu.integration.notification.email.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Mail {
    private String from; //remitente del correo
    private String to; //destinatario del correo
    private String subject; // Asunto del correo
    private Map<String, Object> model; // Modelo de datos para la pantalla

}