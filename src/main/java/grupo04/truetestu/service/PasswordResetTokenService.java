package grupo04.truetestu.service;

import grupo04.truetestu.model.entity.PasswordResetToken;

public interface PasswordResetTokenService {
    void createAndSendPasswordResetToken(String email) throws Exception;
    PasswordResetToken findByToken(String token);
    void removeResetToken(PasswordResetToken passwordResetToken);
    boolean isValidToken(String token);
    void resetPassword(String token, String newPassword);
}
