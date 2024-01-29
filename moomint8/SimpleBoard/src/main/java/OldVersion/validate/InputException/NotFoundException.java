package OldVersion.validate.InputException;

public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super("[ERROR] " + message);
    }
}
