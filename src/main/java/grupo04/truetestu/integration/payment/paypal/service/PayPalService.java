package grupo04.truetestu.integration.payment.paypal.service;

import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.integration.payment.paypal.dto.*;
import grupo04.truetestu.model.entity.Compra;
import grupo04.truetestu.repository.CompraRepository;
import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.Base64;
import java.util.Collections;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class PayPalService {

    @Value("${paypal.client-id}")
    private String clientId;

    @Value("${paypal.client-secret}")
    private String clientSecret;

    @Value("${paypal.api-base}")
    private String apiBase;

    @NonNull
    private CompraRepository compraRepository;
    private RestClient paypalClient;

    @PostConstruct
    public void init() {
        paypalClient = RestClient
                .builder()
                .baseUrl(apiBase)
                .build();
    }

    public String getAccessToken() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        // Solicitud POST para obtener el token de acceso
        return Objects.requireNonNull(
                        paypalClient.post()
                                .uri("/v1/oauth2/token")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .header(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder()
                                        .encodeToString((clientId + ":" + clientSecret).getBytes()))
                                .body(body)
                                .retrieve()
                                .toEntity(TokenResponse.class)
                                .getBody())
                .getAccessToken();  // Extraemos el token de acceso de la respuesta
    }

    public OrderResponse createOrder(Integer compraId, String returnUrl, String cancelUrl) {
        // Buscar la Compra por ID en el repositorio
        Compra compra = compraRepository.findById(compraId)
                .orElseThrow(ResourceNotFoundException::new);

        // Construcción de la solicitud de Pedido de Compra
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setIntent("CAPTURE");

        // Creación del monto (en USD) con el valor obtenido de la compra
        Amount amount = new Amount();
        amount.setCurrencyCode("USD");
        amount.setValue(compra.getMonto().toString());  // 'compra.getMonto()' debe devolver el monto del pago

        // Creación de la unidad de compra con el monto y la referencia del compra
        CompraUnit compraUnit = new CompraUnit();  // Aquí usamos CompraUnit
        compraUnit.setReferenceId(compra.getId().toString());  // Usamos el ID del 'compra' como referencia
        compraUnit.setAmount(amount);  // Se asigna el monto calculado previamente

        // Añadimos la unidad de compra a la solicitud de orden
        orderRequest.setCompraUnits(Collections.singletonList(compraUnit));  // Usamos el método adecuado para agregar la unidad de compra

        // Creación del contexto de la aplicación (como las URLs de retorno y cancelación)
        ApplicationContext applicationContext = ApplicationContext.builder()
                .brandName("TrueTestu")  // Usamos el nombre de tu aplicación
                .returnURL(returnUrl)
                .cancelURL(cancelUrl)
                .build();

        // Asignamos el contexto de la aplicación a la solicitud de la orden
        orderRequest.setApplicationContext(applicationContext);

        // Realizamos la solicitud POST para crear la orden de pago
        return paypalClient.post()
                .uri("/v2/checkout/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())  // Usamos el token obtenido
                .body(orderRequest)
                .retrieve()
                .toEntity(OrderResponse.class)
                .getBody();
    }

    public OrderCaptureResponse captureOrder(String orderId) {
        // Realizamos la solicitud POST para capturar el pago de la orden
        return paypalClient.post()
                .uri("/v2/checkout/orders/{order_id}/capture", orderId)  // 'orderId' se pasa como parámetro en la URL
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())  // Usamos el token obtenido
                .retrieve()
                .toEntity(OrderCaptureResponse.class)
                .getBody();
    }
}
