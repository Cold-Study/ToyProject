package OldVersion.validate;

import OldVersion.validate.InputException.NotInListRangeException;

import java.util.ArrayList;

public class ValidateInputRange {

    /* 설명. 설정한 숫자 리스트 범위 내의 값이 맞는지 검증 */
    public void isInNumberList(int input, ArrayList<Integer> numberOfTitleSelection) throws NotInListRangeException {
        if (!numberOfTitleSelection.contains(input)) {
            throw new NotInListRangeException("해당 메뉴는 존재하지 않습니다. 정확한 값을 입력해주시기 바랍니다.");
        }
    }
}
