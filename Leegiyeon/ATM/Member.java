package ATM;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Member {
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

    public Member() {
    }

    Member[] members = new Member[6];


    public Member(int id, int accountNumber, String name, String pwd, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        System.out.println("고객님 계좌의 잔액은" + members[id].balance + "원 입니다.");
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

    public void signUp(int id) {
        Scanner sc = new Scanner(System.in);
        accountNumber = (int) (Math.random() + 1000);
        System.out.print("이름을 입력해주세요: ");
        name = sc.nextLine();
        System.out.print("사용하실 비밀번호를 입력해주세요: ");
        pwd = sc.nextLine();
        members[id] = new Member(id, accountNumber, name, pwd, 0);
        System.out.println("가입된 회원정보는 " + Arrays.toString(members) + " 입니다.");
        System.out.println("가입된 회원정보는 " + members[id] + " 입니다.");
    }

    public boolean login(boolean login) {
        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호를 입력해주세요: ");
        accountNumber = sc.nextInt();

//        System.out.println("member account: " + members[3].accountNumber);

//        id = 0;
        for (int i = 0; i < members.length; i++) {
            if (accountNumber == members[i].accountNumber) {
                id = i;
                System.out.print("비밀번호를 입력해주세요: ");
                pwd = sc.next();
//                System.out.println("member pwd: " + members[id].pwd);
//                System.out.println("pwd: " + pwd);
                if (Objects.equals(pwd, members[id].pwd)) {         // Memo. pwd == members[id].pwd 는 적용이 안됨
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

    // 기존 가입 회원
    public void memberManager() {

        members[0] = new Member(0, 1111, "Grace", "abcd1234", 5320000.0);
        members[1] = new Member(1, 5555, "Julia", "abcd5678", 8320000.0);
        members[2] = new Member(2, 6666, "Tom", "abcd8765", 49920000.0);
        members[3] = new Member(3, 4444, "Wendy", "abcd1234", 4320000.0);
        members[4] = new Member(4, 2222, "John", "qwer1234", 41150000.0);
        members[5] = new Member(5, 3333, "Suzy", "qwer4321", 60000000.0);
    }

    public void deposit() {
//        Deposit deposit = new Deposit();
//        deposit.howMuch();
        balance = members[id].balance;
        System.out.print("입금할 금액을 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        double deposit = sc.nextDouble();

        if (deposit > 0) {
            balance += deposit;
            members[id].balance = balance;
            System.out.println("입금 후 잔액은 " + balance + "원 입니다.");
            System.out.println("서비스를 이용해주셔서 감사합니다.");
        } else {
            System.out.println("입금하실 금액을 다시확인해 주세요.");
            deposit();
        }
    }


    public void withdraw() {
        balance = members[id].balance;
        System.out.print("출금할 금액을 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        double withdraw = sc.nextDouble();

        if (balance >=  withdraw) {
            balance -= withdraw;
            members[id].balance = balance;
            System.out.println("출금 후 잔액은 " + balance + "원 입니다.");
            System.out.println("서비스를 이용해주셔서 감사합니다.");
        } else {
            System.out.println("출금하실 금액을 다시 확인해주세요.");
            withdraw();
//            System.out.println("재귀");  // Depth 추가됨
        }
    }
}

