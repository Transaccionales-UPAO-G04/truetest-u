package grupo04.truetestu.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUsuarioDetails implements UserDetails {

    private String username;
    private String password;
    private String role; // Suponiendo que tienes un rol
    private boolean isEnabled;

    // Constructor
    public CustomUsuarioDetails(String username, String password, String role, boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convertimos el rol a un objeto GrantedAuthority
        return Collections.singletonList(() -> "ROLE_" + this.role); // Asegúrate de que el rol tenga el prefijo "ROLE_"
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    // Métodos adicionales si necesitas información adicional sobre el usuario
    public String getRole() {
        return this.role;
    }
}
