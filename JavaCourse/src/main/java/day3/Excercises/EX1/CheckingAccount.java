package day3.Excercises.EX1;

public class CheckingAccount extends Account {
    public CheckingAccount(String n, double b) {
        super(n, b);
    }

    @Override
    public void withdraw(double amt) {
        if (getBalance() - amt >= 0) {
            super.withdraw(amt);
        }
    }
}
