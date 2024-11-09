package grupo04.truetestu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TruetestUApplication {
    public static void main(String[] args) {
        SpringApplication.run(TruetestUApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TrueTest-u API")
                        .version("v2")
                        .description("API para el sistema TrueTest-u, diseñado para gestionar la orientación vocacional y las interacciones entre estudiantes y mentores."));
    }
}
