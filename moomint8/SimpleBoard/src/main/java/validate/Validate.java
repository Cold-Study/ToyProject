package validate;

import repository.MemberRepository;
import validate.InputException.NotInListRangeException;
import validate.InputException.NotNumberException;

import java.util.ArrayList;

public class Validate {

    /* 설명. 메뉴에 대한 Input을 검증하는 메소드입니다. */
    public static void menu(String input, ArrayList<Integer> numberOfTitleSelection) throws NotNumberException, NotInListRangeException {
        ValidateInputType validateInputType = new ValidateInputType();
        validateInputType.isNumber(input);                                  // 숫자가 맞는지 검증

        ValidateInputRange validateInputRange = new ValidateInputRange();
        validateInputRange.isInNumberList(Integer.parseInt(input), numberOfTitleSelection);   // 리스트 안에 있는 범위 값인지 검증
    }
}
