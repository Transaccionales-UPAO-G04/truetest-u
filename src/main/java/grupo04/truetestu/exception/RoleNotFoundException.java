package grupo04.truetestu.exception;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException() {
        super("ERROR: Rol no encontrado");
    }

    public RoleNotFoundException(String msg) {
        super(msg);
    }
}
