package grupo04.truetestu.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SwaggerConfig {

    @Bean
    @Primary
    public OpenAPI truetestUOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Prueba Vocacional API")
                        .version("1.0")
                        .description("API para gestionar pruebas vocacionales"));
    }
}
