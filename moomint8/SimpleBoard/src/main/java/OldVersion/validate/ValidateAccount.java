package OldVersion.validate;

import OldVersion.model.Member;
import OldVersion.repository.MemberRepository;
import OldVersion.validate.InputException.NotFoundException;
import OldVersion.validate.InputException.WrongAccountPwd;

public class ValidateAccount {

    public void member(String id, String pwd, MemberRepository memberRepository) throws NotFoundException, WrongAccountPwd {
        Member member = memberRepository.findMemberID(id);
        if (member == null) {       // id 와 같은 회원이 존재하지 않으면
            throw new NotFoundException("존재하지 않는 계정입니다.");
        }
        if (!member.getPwd().equals(pwd)) {     // 비밀번호가 틀리면
            throw new WrongAccountPwd("비밀번호가 틀렸습니다.");
        }
        System.out.println("로그인 성공!");
    }
}
