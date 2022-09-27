package labs;

public class CheckingAccount extends Account {
    private double limit = 400;

    public CheckingAccount(int id, double balance, double limit) {
        super(id, balance);
        this.limit = limit;
    }

    public void withdraw(double amount) {
        if (super.getBalance() - amount < 0 - limit) {
            System.out.println("You cannot withdraw!");
        } else {
            // super.balance -= amount
            super.setBalance(super.getBalance() - amount);
        }
    }
}
