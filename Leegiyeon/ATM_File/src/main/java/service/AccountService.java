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
    private final AccountRepository ar = new AccountRepository();

    public void Deposit(int accountNo) {
        if(accountlist.isEmpty()) accountlist = ar.allAccounts();

        long balance = ar.balance(accountNo); // 해당 계좌의 잔액 조회
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

                ar.deposit(accountNo, password, balance);
                break;
            }
        }
    }

    public void selectWithdraw(int accountNo) {
        Account selectedMember = ar.selectAccount(accountNo);

        if (selectedMember == null) {
            System.out.println("그런 회원이 없네요!~");
        } else {
            System.out.println("조회된 회원은: " + selectedMember);
        }
    }

    public void selectBalance(int accountNo) {
        Account selectedMember = ar.selectAccount(accountNo);

        if (selectedMember == null) {
            System.out.println("그런 회원이 없네요!~");
        } else {
            System.out.println("조회된 회원은: " + selectedMember);
        }
    }

    public void selectSignUp(Account account) {

        int lastAccountNo = ar.selectLastMemberNo();
        account.setAccountNo(lastAccountNo + 1);

        int result = ar.registAccount(account);
        if (result == 1) {
            System.out.println(account.getAccountNo() + "의 계좌번호로 가입되었습니다.");
        }
    }

    public void deleteMember(int accountNo) {
        int result = ar.deleteAccount(accountNo);
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

        Account selectedAccount = ar.selectAccount(accountNo);

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

        Account checkAccount = ar.checkAccount(accountNo,pwd);

        if (checkAccount == null) {
            System.out.println("입력하신 비밀번호가 틀렸습니다.");
            return true;
        } else {
            System.out.println("조회된 비밀번호는는: " + pwd);
            password = pwd;
            return false;
        }
    }
}