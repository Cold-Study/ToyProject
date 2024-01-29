package repository;

import aggregate.Account;
import stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

public class AccountRepository {

    private ArrayList<Account> accountList = new ArrayList<>();

    public AccountRepository() {

        File file = new File("src/main/java/db/ATMDB.dat");
        if (!file.exists()) {
            ArrayList<Account> accounts = new ArrayList<>();

            accounts.add(new Account(1111, 1111, 2500000));
            accounts.add(new Account(1112, 1112, 500000));
            accounts.add(new Account(2222, 2222, 3500000));
            accounts.add(new Account(3333, 3333, 4500000));

            saveAccounts(accounts);
        }

        loadAccounts();
    }

    public void saveAccounts(ArrayList<Account> accounts) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/db/ATMDB.dat")));

            for (Account account : accounts) {
                oos.writeObject(account);
            }

            oos.flush();
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

    public void loadAccounts() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/main/java/db/ATMDB.dat")));

            while (true) {
                accountList.add((Account) (ois.readObject()));
            }

        } catch (EOFException e) {
            System.out.println("계좌 정보 모두 로딩됨...");
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

    public ArrayList<Account> allAccounts() {
        return accountList;
    }

    // 계좌번호 확인
    public Account selectAccount(int accounNo) {
        for (Account account : accountList) {
            if (account.getAccountNo() == accounNo) return account;
        }
        return null;
    }


    // 입력한 계좌번호의 비밀번호 확인
    public Account checkAccount(int accountNo, int pwd) {
        for (Account account : accountList) {
            if (account.getAccountNo() == accountNo) {
                if (account.getPwd() == pwd) return account;
            }
        }
        return null;
    }

    public int selectLastMemberNo() {
        return accountList.get(accountList.size() - 1)
                          .getAccountNo();
    }

    public int registAccount(Account account) {
        MyObjectOutput moo = null;
        try {
            moo = new MyObjectOutput(
                    new BufferedOutputStream(
                            new FileOutputStream("src/main/java/db/ATMDB.dat", true)));

            moo.writeObject(account);

            accountList.add(account);

            moo.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 1;
    }

    public int deleteAccount(int accountNo) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountNo() == accountNo) {
                accountList.remove(i);
                saveAccounts(accountList);
                return 1;
            }
        }
        return 0;
    }


    public long balance(int accountNo) {
        for (Account account : accountList) {
            if (account.getAccountNo() == accountNo) {
                return account.getBalance();
            }
        }
        return 0;
    }

    public void updateAccounts(ArrayList<Account> accountList) {
        saveAccounts(accountList);
    }

    public void deposit(int accountNo, int pwd, long balance) {
        for (Account account : accountList) {
            if (account.getAccountNo() == accountNo) {
                deleteAccount(accountNo);

                break;
            }
        }

        accountList.add(new Account(accountNo,pwd,balance));
        saveAccounts(accountList);

    }
}