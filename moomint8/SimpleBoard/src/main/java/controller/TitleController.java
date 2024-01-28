package controller;

import view.TitlePage;

import java.util.ArrayList;
import java.util.List;

public class TitleController {

    /* 설명. 타이틀 메뉴에서 선택 가능한 숫자 리스트. */
    private static final ArrayList<Integer> NUMBER_OF_TITLE_SELECTION = new ArrayList<>(List.of(1, 2, 9));
    public void selectTitleMenu() {
        TitlePage titlePage = new TitlePage();
        MemberController memberController = new MemberController();

        while (true) {
            try {
                int input = titlePage.printTitle(NUMBER_OF_TITLE_SELECTION);

                switch (input) {
                    case 1:     // 회원 페이지로 이동
                        memberController.selectMemberMenu();
                        break;
                    case 2:     // 게시판 페이지로 이동
                        System.out.println("게시판 서비스 구현 위치");
                        break;
                    case 9:     // 프로그램 종료
                        System.out.println("프로그램을 종료합니다...");
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
