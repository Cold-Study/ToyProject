package OldVersion.validate;

import OldVersion.model.Member;
import OldVersion.repository.MemberRepository;
import OldVersion.validate.InputException.NotFoundException;
import OldVersion.validate.InputException.NotInListRangeException;
import OldVersion.validate.InputException.NotNumberException;
import OldVersion.validate.InputException.WrongAccountPwd;

import java.util.ArrayList;

public class Validate {

    /* 설명. 메뉴에 대한 Input을 검증하는 메소드입니다. */
    public static void menu(String input, ArrayList<Integer> numberOfTitleSelection) throws NotNumberException, NotInListRangeException {
        ValidateInputType validateInputType = new ValidateInputType();
        validateInputType.isNumber(input);                                  // 숫자가 맞는지 검증

        ValidateInputRange validateInputRange = new ValidateInputRange();
        validateInputRange.isInNumberList(Integer.parseInt(input), numberOfTitleSelection);   // 리스트 안에 있는 범위 값인지 검증
    }

    /* 설명. 계정 검증(id, pwd) */
    public static void account(String id, String pwd, MemberRepository memberRepository) throws WrongAccountPwd, NotFoundException {
        Member member = null;
        ValidateAccount validateAccount = new ValidateAccount();
        validateAccount.member(id, pwd, memberRepository);
    }
}
