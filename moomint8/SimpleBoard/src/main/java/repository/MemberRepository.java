package repository;

import model.Member;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {
    private ArrayList<Member> memberList = new ArrayList<>();

    public MemberRepository() {
        File file = new File("src/main/java/db/memberDB.dat");
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
                            new FileOutputStream("src/main/java/db/memberDB.dat")));

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
                            new FileInputStream("src/main/java/db/memberDB.dat")));

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
}
