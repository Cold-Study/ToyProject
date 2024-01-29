package simpleboard.aggregate;

import java.io.Serializable;

public class Member implements Serializable {
    private int memberNo;           // 회원 번호
    private String id;              // 회원 아이디
    private String pwd;             // 회원 비밀번호
    private String name;            // 회원 이름
    private String nick;            // 회원 닉네임
    private MemberStatus memberStatus;      // 회원 삭제 여부

    public Member(int memberNo, String id, String pwd, String name, String nick) {
        this.memberNo = memberNo;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.nick = nick;
        this.memberStatus = MemberStatus.ACTIVE;
    }

    public Member(int memberNo, String id, String pwd, String name, String nick, MemberStatus memberStatus) {
        this.memberNo = memberNo;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.nick = nick;
        this.memberStatus = memberStatus;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }
}
