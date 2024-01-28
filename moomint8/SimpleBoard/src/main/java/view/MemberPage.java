package view;

import validate.InputException.NotInListRangeException;
import validate.InputException.NotNumberException;
import validate.ValidateInputRange;
import validate.ValidateInputType;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberPage {

    /* 설명. 회원 페이지입니다. 선택된 메뉴를 반환합니다. */
    public int printMemberMainPage(ArrayList<Integer> numberOfMemberSelection) throws NotNumberException, NotInListRangeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("============== 게시판 프로그램 ==============");
        System.out.println("1. 회원 전체 조회");
        System.out.println("2. 회원가입");
        System.out.println("3. 회원 정보 변경");
        System.out.println("4. 로그인/로그아웃 구현 위치");

        System.out.println("9. 메인 페이지 복귀");
        System.out.print("메뉴를 선택해주세요 : ");

        String input = sc.nextLine();

        validateMemberMainPageInput(input, numberOfMemberSelection);

        return Integer.parseInt(input);
    }

    /* 설명. 회원 페이지의 Input 값이 올바른지 검증하는 메소드입니다. */
    private void validateMemberMainPageInput(String input, ArrayList<Integer> numberOfMemberSelection) throws NotNumberException, NotInListRangeException {
        ValidateInputType validateInputType = new ValidateInputType();
        validateInputType.isNumber(input);                                  // 숫자가 맞는지 검증

        ValidateInputRange validateInputRange = new ValidateInputRange();
        validateInputRange.isInNumberList(Integer.parseInt(input), numberOfMemberSelection);   // 리스트 안에 있는 범위 값인지 검증
    }

}
