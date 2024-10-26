package grupo04.truetestu.security;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.model.entity.Usuario;
import grupo04.truetestu.repository.UsuarioRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor

public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRespository usuarioRespository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRespository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("Usuario no econtrado con el email" + email));

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getRole().getName().name());

        return new UserPrincipal(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getContraseña(),
                Collections.singletonList(authority),
                usuario
        );

    }
}
