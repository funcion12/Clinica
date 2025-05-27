package exception;

public class ExceptionUsuarioNoExiste extends RuntimeException {
    public ExceptionUsuarioNoExiste(String message) {
        super(message);
    }
}
