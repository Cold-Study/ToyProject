package view;

import validate.InputException.NotInListRangeException;
import validate.InputException.NotNumberException;
import validate.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class TitlePage {

    /* 설명. 메인 페이지입니다. 선택된 메뉴를 반환합니다. */
    public int printTitle(ArrayList<Integer> numberOfTitleSelection) throws NotNumberException, NotInListRangeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n============== 게시판 프로그램 ==============");
        System.out.println("1. 회원 서비스");
        System.out.println("2. 게시판 서비스");
        System.out.println("9. 프로그램 종료");
        System.out.print("메뉴를 선택해주세요 : ");

        String input = sc.nextLine();

        /* 설명. Title 페이지의 Input 값이 올바른지 검증하는 메소드입니다. */
        Validate.menu(input, numberOfTitleSelection);

        return Integer.parseInt(input);
    }
}
