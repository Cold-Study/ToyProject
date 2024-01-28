package view;

import validate.InputException.NotInListRangeException;
import validate.InputException.NotNumberException;
import validate.ValidateInputType;
import validate.ValidateInputRange;

import java.util.ArrayList;
import java.util.Scanner;

public class TitlePage {

    /* 설명. 메인 페이지입니다. 선택된 값을 반환합니다. */
    public int printTitle(ArrayList<Integer> numberOfTitleSelection) throws NotNumberException, NotInListRangeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("============== 게시판 프로그램 ==============");
        System.out.println("1. 회원 서비스");
        System.out.println("2. 게시판 서비스");
        System.out.println("9. 프로그램 종료");
        System.out.print("메뉴를 선택해주세요 : ");

        String input = sc.nextLine();

        validateTitleInput(input, numberOfTitleSelection);

        return Integer.parseInt(input);
    }

    /* 설명. Title 페이지의 Input 값이 올바른지 검증하는 메소드입니다. */
    private void validateTitleInput(String input, ArrayList<Integer> numberOfTitleSelection) throws NotNumberException, NotInListRangeException {
        ValidateInputType validateInputType = new ValidateInputType();
        validateInputType.isNumber(input);                                  // 숫자가 맞는지 검증

        ValidateInputRange validateInputRange = new ValidateInputRange();
        validateInputRange.isInNumberList(Integer.parseInt(input), numberOfTitleSelection);   // 리스트 안에 있는 범위 값인지 검증
    }
}
