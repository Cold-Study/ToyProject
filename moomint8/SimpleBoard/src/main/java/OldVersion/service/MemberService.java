package OldVersion.service;

import OldVersion.model.Member;
import OldVersion.repository.MemberRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService {
//    private final MemberRepository memberRepository;
    public MemberService() {
//        memberRepository = new MemberRepository();
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

    /* 설명. 회원가입 메소드 */
    public void signUp(MemberRepository memberRepository) {
        Member newMember = null;

        int memberNo = memberRepository.findLastMemberNo() + 1;

        Scanner sc = new Scanner(System.in);

        String id;
        while (true) {
            System.out.print("아이디 : ");
            id = sc.nextLine();
            if (duplicateID(id, memberRepository)) {        // 중복된 아이디가 없을 시
                break;
            }
        }

        System.out.print("비밀번호 : ");
        String pwd = sc.nextLine();

        System.out.print("이름 : ");
        String name = sc.nextLine();

        String nick;
        while (true) {
            System.out.print("닉네임 : ");
            nick = sc.nextLine();
            if (duplicateNick(nick, memberRepository)) {        // 중복된 닉네임이 없을 시
                break;
            }
        }

        newMember = new Member(memberNo, id, pwd, name, nick);

        int result = memberRepository.registMember(newMember);
        if (result == 1) {
            System.out.println(newMember.getNick() + "님의 회원 가입이 성공하였습니다.");
        }
    }

    /* 설명. 중복되는 닉네임인지 검증하는 메소드 */
    private boolean duplicateNick(String nick, MemberRepository memberRepository) {
        Member member = memberRepository.findMemberNick(nick);

        if (member != null) {
            System.out.println("중복되는 닉네임입니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    /* 설명. 중복되는 아이디인지 검증하는 메소드 */
    private boolean duplicateID(String id, MemberRepository memberRepository) {
        Member member = memberRepository.findMemberID(id);

        if (member != null) {
            System.out.println("중복되는 아이디입니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }
}
