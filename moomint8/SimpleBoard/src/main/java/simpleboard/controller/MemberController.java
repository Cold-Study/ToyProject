package simpleboard.controller;

import simpleboard.dto.MemberDTO;
import simpleboard.service.MemberService;

import java.util.ArrayList;

public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /* 설명. 전체 회원 조회 */
    public ArrayList<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }
}
