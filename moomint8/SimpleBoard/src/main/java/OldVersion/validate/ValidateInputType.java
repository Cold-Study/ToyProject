package OldVersion.validate;

import OldVersion.validate.InputException.NotNumberException;

public class ValidateInputType {

    /* 설명. input 값이 int 형변환이 가능한지 검증하는 메소드 */
    public void isNumber(String input) throws NotNumberException {
        try {
            int validateInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotNumberException("숫자만 입력 가능합니다.");
        }
    }


}
