package labs;

import java.util.ArrayList;

public class AccountTesting {

    public static void main(String[] args) {
        Account account1 = new Account(0, 1000);
        account1.withdraw(10000);

        System.out.println(account1.getBalance());

        CheckingAccount account2 = new CheckingAccount(1, 1500, 100);

        ArrayList<Account> accounts = new ArrayList<>();
        // Account is a parent of two types of accounts so...
        for (int i = 0; i < 10; i++) {
            Account acc = new CheckingAccount(i, 1000, 500);
            accounts.add(acc);
        }

        account2.withdraw(10000);

        System.out.println(account2.getBalance());

        SavingsAccount account3 = new SavingsAccount(2, 900);
        account3.withdraw(10000);

        System.out.println(account3.getBalance());

    }

}
