package grupo04.truetestu.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;


//http://localhost:8080/api/v2/swagger-ui/index.html
@Configuration
public class OpenAPIConfig {

    @Value("${truetest-u.openapi.dev-url}")
    private String devUrl;

    @Value("${truetest-u.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        // Definir el servidor de desarrollo
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        // Definir el servidor de producción
        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        // Información de contacto
        Contact contact = new Contact();
        contact.setEmail("aoncoyp1@upao.edu.pe");
        contact.setName("Grupo05 Trasnsaccionales");
        contact.setUrl("https://hampcode.com");

        // Licencia
        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        // Información general de la API
        Info info = new Info()
                .title("API de Prueba Vocacional TrueTest-U")
                .version("1.0")
                .contact(contact)
                .description("Esta API expone endpoints para la gestion de pruebas vocacionales")
                .termsOfService("https://www.truetest-u.com/terms")
                .license(mitLicense);

        // Configuración de seguridad JWT
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .name("JWT Authentication");

        Components components = new Components()
                .addSecuritySchemes("bearerAuth", securityScheme);

        // Requerimiento de seguridad para utilizar en las operaciones
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");


        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer))
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}
