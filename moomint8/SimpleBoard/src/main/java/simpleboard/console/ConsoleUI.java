package simpleboard.console;

import simpleboard.controller.BoardController;
import simpleboard.controller.MemberController;
import simpleboard.dto.MemberDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    private final MemberController memberController;
    private final BoardController boardController;

    private final String WRONG_CHOICE_MENU = "존재하지 않는 메뉴입니다. 다시 선택하세요.";

    public ConsoleUI(MemberController memberController, BoardController boardController) {
        this.memberController = memberController;
        this.boardController = boardController;
    }

    public void start() {
        showTitleMenu();
    }

    private void showTitleMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n============== 게시판 프로그램 ==============");
            System.out.println("1. 회원 서비스");
            System.out.println("2. 게시판 서비스");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해주세요 : ");

            int input = scanner.nextInt();

            switch (input) {
                case 1:     // 회원 페이지로 이동
                    showMemberMenu();
                    break;
                case 2:     // 게시판 페이지로 이동
                    System.out.println("게시판 페이지 구현 위치");
                    break;
                case 9:     // 프로그램 종료
                    System.out.println("프로그램을 종료합니다...");
                    scanner.close();
                    return;
                default:
                    System.out.println(WRONG_CHOICE_MENU);
            }
        }
    }

    private void showMemberMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n============== 회원 페이지 ==============");
            System.out.println("1. 모든 회원 정보 보기");
            System.out.println("2. 회원가입");
            System.out.println("3. 로그인");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 탈퇴");
            System.out.println("9. 메인 페이지 복귀");
            System.out.print("메뉴를 선택해주세요 : ");

            int input = scanner.nextInt();

            switch (input) {
                case 1:     // 모든 회원 정보 보기
                    showAllMember();
                    break;
                case 2:     // 회원가입
                    System.out.println("회원가입 구현 위치");
                    break;
                case 3:     // 회원 정보 변경
                    System.out.println("로그인 구현 위치");
                    break;
                case 4:     // 로그인/로그아웃
                    System.out.println("회원 정보 수정 구현 위치");
                    break;
                case 5:     // 회원 탈퇴
                    System.out.println("회원 탈퇴 구현 위치");
                    break;
                case 9:     // 메인 페이지 복귀
                    System.out.println("메인 페이지 복귀");
                    return;
                default:
                    System.out.println(WRONG_CHOICE_MENU);
            }
        }
    }

    private void showAllMember() {
        ArrayList<MemberDTO> members = memberController.getAllMembers();
        System.out.println("\n-------- 전체 회원 조회 결과 --------");
        for (MemberDTO member : members) {
            System.out.println("ID : " + member.getId() + "  이름 : " + member.getName() + "  닉네임 : " + member.getNick());
        }
    }
}
