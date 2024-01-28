package service;

import model.Member;
import repository.MemberRepository;

import java.util.ArrayList;

public class MemberService {
    public MemberService() {
    }

    /* 설명. 모든 회원 조회 메소드 */
    public void selectAllMembers(MemberRepository memberRepository) {
        ArrayList<Member> selectedMembers = memberRepository.selectAllMembers();

        /* 설명. 가입한 회원이 있는 경우 닉네임 출력 */
        if (!selectedMembers.isEmpty()) {
            for (Member member : selectedMembers) {
                System.out.println(member.getNick());
            }
            return;
        }

        /* 설명. 회원이 없는 경우 */
        System.out.println("아직 가입한 회원이 없습니다...");
    }
}
