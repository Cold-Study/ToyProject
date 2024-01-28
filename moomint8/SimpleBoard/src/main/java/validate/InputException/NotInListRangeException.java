package validate.InputException;

public class NotInListRangeException extends Exception {
    public NotInListRangeException(String message) {
        super("[ERROR] " + message);
    }
}
