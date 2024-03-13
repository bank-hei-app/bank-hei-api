package school.hei.bankapi.exeption;

public class BadValueException extends RuntimeException {
    public BadValueException(String message) {
        super((message));
    }
}