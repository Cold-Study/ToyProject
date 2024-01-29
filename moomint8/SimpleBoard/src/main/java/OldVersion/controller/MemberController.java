package OldVersion.controller;

import OldVersion.repository.MemberRepository;
import OldVersion.service.MemberService;
import OldVersion.view.MemberPage;

import java.util.ArrayList;
import java.util.List;

public class MemberController {

    /* 설명. 회원 메뉴에서 선택 가능한 숫자 리스트. */
    private static final ArrayList<Integer> NUMBER_OF_MEMBER_SELECTION = new ArrayList<>(List.of(1, 2, 3, 4, 9));

    public void selectMemberMenu(MemberRepository memberRepository) {
        MemberPage memberPage = new MemberPage();
        MemberService memberService = new MemberService();

        while (true) {
            try {
                int input = memberPage.printMemberMainPage(NUMBER_OF_MEMBER_SELECTION);

                switch (input) {
                    case 1:     // 회원 전체 조회
                        System.out.println("\n------ 회원 전체 조회 결과 ------");
                        memberService.selectAllMembers(memberRepository);
                        break;
                    case 2:     // 회원 가입
                        System.out.println("\n------ 회원 가입 ------");
                        memberService.signUp(memberRepository);
                        break;
                    case 3:     // 회원 정보 변경
                        System.out.println("회원 정보 변경 구현 위치");
                        break;
                    case 4:     // 로그인/로그아웃
                        System.out.println("로그인 로그아웃 구현 위치");
                        break;
                    case 9:     // 메인 페이지 복귀
                        System.out.println("메인 페이지 복귀");
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
