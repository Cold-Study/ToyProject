package simpleboard.dto;

public class MemberDTO {
    private String id;              // 회원 아이디
    private String pwd;             // 회원 비밀번호
    private String name;            // 회원 이름
    private String nick;            // 회원 닉네임
    private String memberStatus;    // 회원 삭제 여부

    public MemberDTO(String id, String name, String nick) {
        this.id = id;
        this.name = name;
        this.nick = nick;
        this.memberStatus = memberStatus;
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

    public String getMemberStatus() {
        return memberStatus;
    }
}
