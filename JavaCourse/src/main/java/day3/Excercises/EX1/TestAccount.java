package day3.Excercises.EX1;

public class TestAccount {
    public static void main(String[] args) {
        SavingAccount sa= new SavingAccount("joud", 20000, 500);
        CheckingAccount ca = new CheckingAccount("joud", 1000);

        System.out.println("balance:"+sa.getBalance());
        System.out.println("Limit:"+sa.getLimit());
        sa.withdraw(100);
        sa.withdraw(200000);

        System.out.println("balance after withdraw:"+sa.getBalance());

        System.out.println("----------------------\n \nbalance:"+ca.getBalance());
        ca.withdraw(50);
        System.out.println("balance after withdraw:"+ca.getBalance());

    }
}
