package simpleboard.console;

import simpleboard.controller.BoardController;
import simpleboard.controller.MemberController;

import java.util.Scanner;

public class ConsoleUI {
    private final MemberController memberController;
    private final BoardController boardController;

    public ConsoleUI(MemberController memberController, BoardController boardController) {
        this.memberController = memberController;
        this.boardController = boardController;
    }

    public void start() {
        selectTitleMenu();
    }

    private void selectTitleMenu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n============== 게시판 프로그램 ==============");
            System.out.println("1. 회원 서비스");
            System.out.println("2. 게시판 서비스");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해주세요 : ");

            int input = sc.nextInt();

            switch (input) {
                case 1:     // 회원 페이지로 이동
                    System.out.println("회원 페이지 구현 위치");
                    break;
                case 2:     // 게시판 페이지로 이동
                    System.out.println("게시판 페이지 구현 위치");
                    break;
                case 9:     // 프로그램 종료
                    System.out.println("프로그램을 종료합니다...");
                    return;
                default:
                    System.out.println("존재하지 않는 메뉴입니다. 다시 선택하세요.");
            }
        }
    }
}
