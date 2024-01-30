package aggregate;

import java.io.Serializable;


public class Account implements Serializable {
    private int accountNo;          // 계좌번호
    private int pwd;                // 계좌비번
    private long balance;            // 게좌잔액

    public Account() {
    }
    public Account(int accountNo, int pwd, long balance) {
        this.accountNo = accountNo;
        this.pwd = pwd;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public int getPwd() {
        return pwd;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", pwd=" + pwd +
                ", balance=" + balance +
                '}';
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
}
