package day2.Excercises.EX3;

public class Account {
    String name;
    private double balance;
    static double annualRate = 0.04;

    public Account(String n, double b){
        name=n;
        balance=b;
    }

    public static double getMonthRate(){
        return annualRate/12;
    }

    public double getMonthInt(){
        double monthrate = getMonthRate();
        return monthrate * balance;
    }

    public void depost(double amt){
        balance += amt;
    }

    public void withdraw(double amt){
        balance -= amt;

    }

    public double getBalance(){
        return balance;
    }
}
