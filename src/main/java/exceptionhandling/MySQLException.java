package exceptionhandling;

public class MySQLException extends RuntimeException {
    public MySQLException(String message) {
        super(message);
    }
}
