package OldVersion.service;

import OldVersion.repository.MemberRepository;
import OldVersion.validate.InputException.NotFoundException;
import OldVersion.validate.InputException.WrongAccountPwd;
import OldVersion.validate.Validate;

/* 설명. 로그인을 담당할 클래스 */
public class AuthenticationService {
    public AuthenticationService() {
    }

    public void login(String id, String pwd, MemberRepository memberRepository) throws WrongAccountPwd, NotFoundException {
        Validate.account(id, pwd, memberRepository);
    }
}
