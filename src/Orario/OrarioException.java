package Orario;

public class OrarioException extends RuntimeException {

    private final String msg;

    public OrarioException(String message) {
        super(message);
        msg = message;
    }

    @Override
    public String toString() {
        return msg;
    }
}
