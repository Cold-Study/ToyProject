package simpleboard.repository;

import simpleboard.aggregate.Member;
import simpleboard.aggregate.MemberStatus;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {
    private final String DB_PATH = "src/main/java/simpleboard/db/memberDB.dat";    // DB 경로
    private ArrayList<Member> memberList = new ArrayList<>();

    /* 설명. 프로그램이 켜지자 마자(MemberRepository()가 실행되자마자) 파일에 dummy 데이터 추가 및 입력받기 */
    public MemberRepository() {

        /* 설명. 회원가입 기능 추가 후 이제는 파일이 기존에 존재하려면(처음이 아니므로) 회원 5명으로 초기화하기를 하지 않는다. */
        File file = new File(DB_PATH);
        if (!file.exists()) {
            ArrayList<Member> members = new ArrayList<>();
            members.add(new Member
                    (1, "user01", "pass01", "이름01", "닉네임01"));
            members.add(new Member
                    (2, "user02", "pass02", "이름02", "닉네임02"));
            members.add(new Member
                    (3, "user03", "pass03", "이름03", "닉네임03", MemberStatus.DELETED));    // 삭제된 회원
            members.add(new Member
                    (4, "user04", "pass04", "이름04", "닉네임04", MemberStatus.DORMANT));    // 휴면인 회원
            members.add(new Member
                    (5, "user05", "pass05", "이름05", "닉네임05"));

            saveMembers(members);
        }

        loadMembers();
    }

    /* 설명. 회원이 담긴 ArrayList를 던지면 파일에 출력(저장)하는 기능 */
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

    public ArrayList<Member> selectAllMembers() {

        return memberList;
    }
}
