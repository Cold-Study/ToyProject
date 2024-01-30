package run;
import aggregate.Account;
import service.AccountService;

import java.util.Scanner;

public class Application {

    private static final AccountService accountServive = new AccountService();

    public static void main(String[] args) {

        int admin = 0;      // 관리자 페이지 이동 권한

        while(true) {

            // Memo. 관리자 인증 > ATM 전원 켜는 경우 하단 부분 Pass
            if (admin == 0) {
                admin++;
                if (checkAdmin() == 0) {
                    break;
                }
            }

            Scanner sc = new Scanner(System.in);

            // Memo. 사용자 인터페이스
            System.out.println("====    ATM    ====");
            System.out.println("==== 1.  입금   ====");
            System.out.println("==== 2.  출금   ====");
            System.out.println("==== 3. 잔액조회 ====");
            System.out.println("==== 9. ADMIN  ====");
            System.out.print("이용하실 서비스 번호를 입력해주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    int accountNo = accountServive.checkAccount();
                    if(accountNo == 0 || accountServive.login(accountNo)){
                        System.out.println("정보가 일치하지 않아 메인 화면으로 이동합니다.");
                        continue;
                    }
                    accountServive.deposit(accountNo);
                    break;
                case 2:
                    int accountNo1 = accountServive.checkAccount();
                    if(accountNo1 == 0 || accountServive.login(accountNo1)){
                        System.out.println("정보가 일치하지 않아 메인 화면으로 이동합니다.");
                        continue;
                    }
                    accountServive.withdraw(accountNo1);
                    break;
                case 3:
                    int accountNo2 = accountServive.checkAccount();
                    if(accountNo2 == 0 || accountServive.login(accountNo2)){
                        System.out.println("정보가 일치하지 않아 메인 화면으로 이동합니다.");
                        continue;
                    }
                    accountServive.balance(accountNo2);
                    break;
                case 9:
                    admin = 0;
                    continue;
                default:
                    System.out.println("번호를 제대로 다시 입력해 주세요");
            }
        }
    }

    // Memo. 관리자 인증
    private static int checkAdmin() {
        while (true) {
            System.out.println("===== 관리자 로그인 =====");
            System.out.print("관리자 비밀번호를 입력해주세요: ");
            int masterPwd = 970516;

            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if (input == masterPwd) {
                if (adminUI()) break;
                else {
                    System.out.println("ATM이 종료되었습니다.");
                    return 0;
                }
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }
        return 1;
    }

    // Memo. 관리자 메뉴
    private static boolean adminUI() {
        boolean flag = true;

        while (flag) {
            Scanner sc = new Scanner(System.in);
            System.out.println("==== 1. 계좌관리 ====");
            System.out.println("==== 2. ATM실행 ====");
            System.out.println("==== 3. ATM종료 ====");
            System.out.print("관리할 서비스를 선택해 주세요: ");
            int adminMenu = sc.nextInt();

            if (adminMenu == 1) {
                accountServive.signUp();
                flag = true;
                continue;
            } else if (adminMenu == 2) {
                System.out.println("ATM을 실행합니다.");
                flag =  true;
            } else if (adminMenu == 3) {
                System.out.println("ATM 전원을 끕니다.");
                flag = false;
            } else {
                System.out.println("번호를 제대로 다시 입력해 주세요");
                continue;
            }
            break;

        }
        return flag;
    }

    // Memo. 계좌 관리

}