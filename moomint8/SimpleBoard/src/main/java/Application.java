import view.TitlePage;

import java.util.ArrayList;
import java.util.List;

public class Application {

    /* 설명. 타이틀 메뉴에서 선택 가능한 숫자 리스트. */
    private static final ArrayList<Integer> NUMBER_OF_TITLE_SELECTION = new ArrayList<>(List.of(1, 2, 9));

    public static void main(String[] args) {

        selectTitleMenu();
    }

    private static void selectTitleMenu() {
        TitlePage titlePage = new TitlePage();
        while (true) {
            try {
                int input = titlePage.printTitle(NUMBER_OF_TITLE_SELECTION);

                switch (input) {
                    case 1:
                        System.out.println("회원 관리 서비스 구현 위치");
                        break;
                    case 2:
                        System.out.println("게시판 서비스 구현 위치");
                        break;
                    case 9:
                        System.out.println("프로그램을 종료합니다...");
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
