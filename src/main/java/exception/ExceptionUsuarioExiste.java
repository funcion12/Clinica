package exception;

public class ExceptionUsuarioExiste extends RuntimeException {
    public ExceptionUsuarioExiste(String message) {
        super(message);
    }
}
