package run;
import aggregate.Account;
import service.AccountService;

import java.util.Scanner;

public class Application {

    private static final AccountService accountServive = new AccountService();

    public static void main(String[] args) {

        while(true) {
            Scanner sc = new Scanner(System.in);
            // Memo. 관리자 인증 및 사용자 설정 페이지 추가
            System.out.println("====    ATM    ====");
            System.out.println("==== 1.  입금   ====");
            System.out.println("==== 2.  출금   ====");
            System.out.println("==== 3. 잔액조회 ====");
            // Memo. 관리자 메뉴 추가
            System.out.println("==== 4. 회원가입 ====");
            System.out.println("==== 9.  종료   ====");
            System.out.print("이용하시고자 하는 서비스를 선택해 주세요: ");
            int input = sc.nextInt();

            int accountNo = accountServive.checkAccount();
            if(accountNo == 0 || accountServive.login(accountNo)){
                System.out.println("정보가 일치하지않아 메인 화면으로 이동합니다.");
                continue;
            }

            switch (input) {
                case 1:
                    accountServive.Deposit(accountNo);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("번호를 제대로 다시 입력해 주세요");
            }
        }
    }

    private static Account signUp() {
        Account newInfo = null;

        Scanner sc = new Scanner(System.in);

        System.out.print("계좌번호를 입력하세요: ");
        int accountNo = sc.nextInt();

        System.out.print("패스워드를 입력하세요: ");
        int pwd = sc.nextInt();

        System.out.print("최초 입금 금액을 입력하세요: ");
        int balance = sc.nextInt();

        newInfo = new Account(accountNo, pwd, balance);

        return newInfo;
    }
}