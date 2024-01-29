package OldVersion.repository;

import OldVersion.model.Member;
import OldVersion.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {
    private final String DB_PATH = "src/main/java/db/memberDB.dat";    // DB 경로
    private ArrayList<Member> memberList = new ArrayList<>();

    public MemberRepository() {
        File file = new File(DB_PATH);
        if (!file.exists()) {       // 가입한 회원이 없는 경우 임의 회원 추가
            ArrayList<Member> members = new ArrayList<>();
            members.add(new Member(1, "user01", "pass01", "회원1", "닉네임1"));
            members.add(new Member(2, "user02", "pass02", "회원2", "닉네임2"));
            members.add(new Member(3, "user03", "pass03", "회원3", "닉네임3"));

            saveMembers(members);
        }

        loadMembers();
    }

    public ArrayList<Member> selectAllMembers() {
        return memberList;
    }

    private void saveMembers(ArrayList<Member> members) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(DB_PATH)));

            /* 설명. 넘어온 회원 수만큼 객체 출력하기 */
            for (Member member : members) {
                oos.writeObject(member);
            }

            oos.flush();                // 출력 시에는 flush 해 줄것
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* 설명. 하나의 회원을 저장하는 메소드입니다. */
    private int saveMember(Member member) {
        MyObjectOutput moo = null;
        try {
            moo = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(DB_PATH, true)));

            /* 설명. 파일로 객체 하나 출력하기 */
            moo.writeObject(member);

            /* 설명. repository의 memberList 추가 */
            memberList.add(member);

            moo.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return 1;
    }

    /* 설명. 파일로부터 회원 객체들을 입력받아 memberList에 쌓기 */
    private void loadMembers() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(DB_PATH)));

            /* 설명. 파일로부터 모든 회원 정보를 읽어 memberList에 추가(add) */
            while (true) {
                memberList.add((Member) (ois.readObject()));
            }
        } catch (EOFException e) {
            System.out.println("회원 정보 모두 로딩됨...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* 설명. 아이디로 멤버 검색 */
    public Member findMemberID(String id) {
        for (Member member : memberList) {
            if (member.getId().equals(id) && !member.isDeleted()) {     // 아이디가 존재하고 탈퇴하지 않았다면
                return member;
            }
        }
        return null;
    }

    /* 설명. 닉네임으로 회원 검색 */
    public Member findMemberNick(String nick) {
        for (Member member : memberList) {
            if (member.getNick().equals(nick) && !member.isDeleted()) {     // 닉네임이 존재하고 탈퇴하지 않았다면
                return member;
            }
        }
        return null;
    }

    /* 설명. 마지막 회원 번호를 찾는 메소드 */
    public int findLastMemberNo() {
        return memberList.get(memberList.size() - 1).getMemberNo();
    }

    public int registMember(Member newMember) {
        return saveMember(newMember);
    }
}
