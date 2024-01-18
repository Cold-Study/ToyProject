package atm;

import java.util.Scanner;

public class AtmUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean isOn = true;
        boolean pass = false;
        int idx = 0; //member index
        Member member = new Member();
        member.memberManager(); // 기존 가입 member load


        while (isOn) {
            System.out.println("====    ATM    ====");
            System.out.println("==== 1.  입금   ====");
            System.out.println("==== 2.  출금   ====");
            System.out.println("==== 3. 잔액조회 ====");
//            System.out.println("==== 4. 회원가입 ====");
            System.out.println("==== 9.  종료   ====");

            System.out.print("PLEASE ENTER THE NUMBER: ");

            int input = sc.nextInt();


            // 각 기능 별 접근 시, 로그인 추후 개발 예정
            if (input == 1) {
                if (member.login(pass)) {
                    member.deposit();
                }
            } else if (input == 2) {
                if (member.login(pass)) {
                    member.withdraw();
                }
            } else if (input == 3) {
                if (member.login(pass)) {
                    member.getBalance();
                }
//            } else if (input == 4) {
//                member.memberManager();
//                member.signUp(idx);
            } else if (input == 9) {
                System.out.println("ATM이 종료됩니다.");
                isOn = false;
            }
            idx++;
        }
    }
}

