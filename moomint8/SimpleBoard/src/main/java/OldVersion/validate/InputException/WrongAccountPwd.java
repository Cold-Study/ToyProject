package OldVersion.validate.InputException;

public class WrongAccountPwd extends Throwable {
    public WrongAccountPwd(String message) {
        super("[ERROR] " + message);
    }
}