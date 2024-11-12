package grupo04.truetestu.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends GenericFilterBean {

    private final TokenProvider tokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String bearerToken = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            String token = bearerToken.substring(7);

            // Validación adicional: verificar si el token tiene dos puntos
            if (token.chars().filter(ch -> ch == '.').count() == 2) {
                System.out.println("Token extraído y validado estructuralmente: " + token);
                if (tokenProvider.validateToken(token)) {
                    Authentication authentication = tokenProvider.getAuthentication(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("Token validado exitosamente y autenticación establecida.");
                } else {
                    System.out.println("Token inválido o expirado.");
                }
            } else {
                System.out.println("Token malformado: falta la estructura adecuada con dos puntos.");
            }
        } else {
            System.out.println("Token de autorización no presente o mal formado.");
        }

        chain.doFilter(request, response);
    }
}