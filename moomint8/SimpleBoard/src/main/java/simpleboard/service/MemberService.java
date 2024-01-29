package simpleboard.service;

import simpleboard.aggregate.Member;
import simpleboard.aggregate.MemberStatus;
import simpleboard.dto.MemberDTO;
import simpleboard.repository.MemberRepository;

import java.util.ArrayList;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* 설명. 전체 조회한 회원들 DTO 형태로 반환 */
    public ArrayList<MemberDTO> getAllMembers() {
        ArrayList<Member> selectedMembers = memberRepository.selectAllMembers();
        ArrayList<MemberDTO> resultMembers = new ArrayList<>();

        for (Member member : selectedMembers) {
            if (member.getMemberStatus() == MemberStatus.ACTIVE) {      // 활성화된 계정이면(휴면, 삭제계정 X)
                resultMembers.add(new MemberDTO(member.getId(), member.getName(), member.getNick()));
            }
        }

        return resultMembers;
    }
}
