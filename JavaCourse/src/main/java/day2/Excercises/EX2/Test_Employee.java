package day2.Excercises.EX2;

public class Test_Employee {
    public static void main(String[] args) {
        Employee e = new Employee("joud",10000, 2017);

        System.out.println(e.name);
        System.out.println(e.calAS());
        System.out.println(e.calSp());
    }
}
