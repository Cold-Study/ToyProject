package run;

import DTO.MemberDTO;

import java.util.Scanner;

public class AtmUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean isOn = true;    // ATM 실행
        boolean pass = false;   // 로그인 확인
        
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.memberManager(); // 기존 가입 member load

        while (isOn) {
            System.out.println("====    ATM    ====");
            System.out.println("==== 1.  입금   ====");
            System.out.println("==== 2.  출금   ====");
            System.out.println("==== 3. 잔액조회 ====");
            System.out.println("==== 9.  종료   ====");

            System.out.print("PLEASE ENTER THE NUMBER: ");
            int input = sc.nextInt();
            
            if (input == 1) {
                if (memberDTO.login(pass)) {
                    memberDTO.deposit();
                }
            } else if (input == 2) {
                if (memberDTO.login(pass)) {
                    memberDTO.withdraw();
                }
            } else if (input == 3) {
                if (memberDTO.login(pass)) {
                    memberDTO.getBalance();
                }
            } else if (input == 9) {
                System.out.println("ATM이 종료됩니다.");
                isOn = false;
            }
        }
    }
}

