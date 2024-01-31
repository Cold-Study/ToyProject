package service;

import aggregate.Account;
import repository.AccountRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountService {

    public int password;

    public AccountService() {
    }

    ArrayList<Account> accountlist = new ArrayList<>();
    private static final AccountRepository accountRepository = new AccountRepository();

    public void deposit(int accountNo) {
        if (accountlist.isEmpty()) accountlist = accountRepository.allAccounts();

        long balance = accountRepository.balance(accountNo); // 해당 계좌의 잔액 조회
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.print("입금하실 금액을 입력해주세요: ");
            long deposit = sc.nextLong();

            System.out.println("deposit : " + deposit);
            if (deposit < 0) {
                System.out.println("0원 이상 입금해주세요.");
            } else {
                balance += deposit;
                System.out.println(deposit + "원 입금해주셨습니다.");
                System.out.println("고객님 계좌의 잔액은 " + balance + "원 입니다.");

                accountRepository.accountUpdate(accountNo, password, balance);     // 새로운 객체에 입금내용 추가
                break;
            }
        }
    }

    public void withdraw(int accountNo) {
        if (accountlist.isEmpty()) accountlist = accountRepository.allAccounts();

        long balance = accountRepository.balance(accountNo); // 해당 계좌의 잔액 조회
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("출금하실 금액을 입력해주세요: ");
            long withdraw = sc.nextLong();

            System.out.println("withdraw : " + withdraw);
            if (withdraw > balance) {
                System.out.println("계좌의 잔액이 부족합니다.");
            } else {
                balance -= withdraw;
                System.out.println(withdraw + "원 출금하셨습니다.");
                System.out.println("고객님 계좌의 잔액은 " + balance + "원 입니다.");

                accountRepository.accountUpdate(accountNo, password, balance);     // 새로운 객체에 출금내용 추가
                break;
            }
        }
    }

    public void balance(int accountNo) {
        if (accountlist.isEmpty()) accountlist = accountRepository.allAccounts();

        long balance = accountRepository.balance(accountNo); // 해당 계좌의 잔액 조회
        System.out.println("고객님의 \'" + accountNo + "\'계좌 잔액은 " + balance + "원 입니다.");
    }

    // Memo. 관리자 계좌관리 메소드 수정 예정
    public void signUp(Account account) {
        int lastAccountNo = accountRepository.selectLastMemberNo();
        account.setAccountNo(lastAccountNo + 1);

        int result = accountRepository.registAccount(account);
        if (result == 1) {
            System.out.println(account.getAccountNo() + "의 계좌번호로 가입되었습니다.");
        }
    }

    public void deleteMember(int accountNo) {
        int result = accountRepository.deleteAccount(accountNo);
        if (result > 0) {
            System.out.println(accountNo + "번호의 계좌를 제거하였습니다.");
            return;
        }

        System.out.println("회원 탈퇴에 실패하였습니다.");
    }

    public int checkAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호를 입력해주세요: ");
        int accountNo = sc.nextInt();

        Account selectedAccount = accountRepository.selectAccount(accountNo);

        if (selectedAccount == null) {
            System.out.println("조회된 계좌가 없습니다.");
            return 0;
        }
        return accountNo;
    }

    public boolean login(int accountNo) {
        if (accountNo == 0) return true;
        Scanner sc = new Scanner(System.in);

        System.out.print("비밀번호를 입력해주세요: ");
        int pwd = sc.nextInt();

        Account checkAccount = accountRepository.checkAccount(accountNo, pwd);

        if (checkAccount == null) {
            System.out.println("입력하신 비밀번호가 틀렸습니다.");
            return true;
        } else {
            password = pwd;
            return false;
        }
    }

    public static void signUp() {

        Scanner sc = new Scanner(System.in);

        System.out.print("계좌번호를 입력하세요: ");
        int accountNo = sc.nextInt();

        System.out.print("패스워드를 입력하세요: ");
        int pwd = sc.nextInt();

        System.out.print("최초 입금 금액을 입력하세요: ");
        int balance = sc.nextInt();

        accountRepository.accountUpdate(accountNo, pwd, balance);
    }
}