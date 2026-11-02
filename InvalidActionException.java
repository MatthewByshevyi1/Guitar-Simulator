public class InvalidActionException extends RuntimeException {

    public InvalidActionException() {
        super("This is not a valid action.");
    }

    public InvalidActionException(String message) {
        super(message);
    }
}