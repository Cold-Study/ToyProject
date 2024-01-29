package OldVersion.validate.InputException;

public class NotNumberException extends Exception {
    public NotNumberException(String message) {
        super("[ERROR] " + message);
    }

}
