package day3.Excercises.EX1;

public class SavingAccount extends Account {
    private int limit;

    public SavingAccount(String n, double b, int limit) {
        super(n, b);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void withdraw(double amt){
        if(getBalance() - amt >= limit){
            super.withdraw(amt);
        }


    }
}
