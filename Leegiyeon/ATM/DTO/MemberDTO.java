package DTO;

import java.util.Objects;
import java.util.Scanner;

public class MemberDTO {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int accountNumber;
    private String name;
    private String pwd;
    private double balance;
    MemberDTO[] memberDTOS = new MemberDTO[6];

    public MemberDTO() {
    }

    public MemberDTO(int id, int accountNumber, String name, String pwd, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
    }

    public double getBalance() {
        System.out.println("고객님 계좌의 잔액은" + memberDTOS[id].balance + "원 입니다.");
        System.out.println("서비스를 이용해주셔서 감사합니다.");
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Member{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }

    public boolean login(boolean login) {
        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호를 입력해주세요: ");
        accountNumber = sc.nextInt();

        for (int i = 0; i < memberDTOS.length; i++) {
            if (accountNumber == memberDTOS[i].accountNumber) {
                id = i;
                System.out.print("비밀번호를 입력해주세요: ");
                pwd = sc.next();

                if (Objects.equals(pwd, memberDTOS[id].pwd)) {         // Memo. pwd == members[id].pwd 는 적용이 안됨
                    login = true;
                    System.out.println("로그인 되었습니다.");
                    break;
                }
            }
        }
        if (!login)
            System.out.println("저희 은행 회원이 아닙니다. 회원가입을 해주세요.");

        return login;

    }

    // 기존 가입된 회원
    public void memberManager() {
        memberDTOS[0] = new MemberDTO(0, 1111, "Grace", "abcd1234", 5320000.0);
        memberDTOS[1] = new MemberDTO(1, 5555, "Julia", "abcd5678", 8320000.0);
        memberDTOS[2] = new MemberDTO(2, 6666, "Tom", "abcd8765", 49920000.0);
        memberDTOS[3] = new MemberDTO(3, 4444, "Wendy", "abcd1234", 4320000.0);
        memberDTOS[4] = new MemberDTO(4, 2222, "John", "qwer1234", 41150000.0);
        memberDTOS[5] = new MemberDTO(5, 3333, "Suzy", "qwer4321", 60000000.0);
    }

    public void deposit() {
        balance = memberDTOS[id].balance;
        System.out.print("입금할 금액을 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        double deposit = sc.nextDouble();

        if (deposit > 0) {
            balance += deposit;
            memberDTOS[id].balance = balance;
            System.out.println("입금 후 잔액은 " + balance + "원 입니다.");
            System.out.println("서비스를 이용해주셔서 감사합니다.");
        } else {
            System.out.println("입금하실 금액을 다시확인해 주세요.");
            deposit();
        }
    }


    public void withdraw() {
        balance = memberDTOS[id].balance;
        System.out.print("출금할 금액을 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        double withdraw = sc.nextDouble();

        if (balance >= withdraw) {
            balance -= withdraw;
            memberDTOS[id].balance = balance;
            System.out.println("출금 후 잔액은 " + balance + "원 입니다.");
            System.out.println("서비스를 이용해주셔서 감사합니다.");
        } else {
            System.out.println("출금하실 금액을 다시 확인해주세요.");
            withdraw();
        }
    }
}

