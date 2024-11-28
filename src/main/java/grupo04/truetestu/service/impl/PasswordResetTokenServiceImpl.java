package grupo04.truetestu.service.impl;

import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.integration.notification.email.dto.Mail;
import grupo04.truetestu.integration.notification.email.service.EmailService;
import grupo04.truetestu.model.entity.PasswordResetToken;
import grupo04.truetestu.model.entity.Usuario;
import grupo04.truetestu.repository.PasswordResetTokenRepository;
import grupo04.truetestu.repository.UsuarioRespository;
import grupo04.truetestu.service.PasswordResetTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor

 public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final UsuarioRespository usuarioRespository;
    private final EmailService emailService;
    private final PasswordEncoder  passwordEncoder;

    @Value("${spring.mail.username}")
    private String mailFrom;


    @Transactional
    @Override
    public void createAndSendPasswordResetToken(String email) throws Exception {
        Usuario usuario = usuarioRespository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con email: " + email));

        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(UUID.randomUUID().toString());
        passwordResetToken.setUsuario(usuario);
        passwordResetToken.setExpiration(10);
        passwordResetTokenRepository.save(passwordResetToken);

        Map<String, Object> model = new HashMap<>();
        String resetUrl = "http://localhost:4200/auth/password-reset/" + passwordResetToken.getToken();
        model.put("usuario", usuario.getEmail());
        model.put("resetUrl", resetUrl);

        Mail mail = emailService.createMail(
                usuario.getEmail(),
                "Restablecer contraseña",
                model,
                mailFrom
        );

        emailService.sendMail(mail, "email/password-reset-template");

    }


    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("Token de restablecimiento de contraseña no encontrado"));
    }

    @Override
    public void removeResetToken(PasswordResetToken passwordResetToken) {
        passwordResetTokenRepository.delete(passwordResetToken);
    }

    @Override
    public boolean isValidToken(String token) {
        return passwordResetTokenRepository.findByToken(token)
                .filter(t->!t.isExpired())
                .isPresent();
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token)
                .filter(t->!t.isExpired())
                .orElseThrow(() -> new ResourceNotFoundException("Token invalido o expirado"));

        Usuario usuario = resetToken.getUsuario();
        usuario.setPassword(passwordEncoder.encode(newPassword));
        usuarioRespository.save(usuario);
        passwordResetTokenRepository.delete(resetToken);
    }
}
