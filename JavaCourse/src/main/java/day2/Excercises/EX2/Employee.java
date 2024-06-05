package day2.Excercises.EX2;

public class Employee {
    String name;
    double salary;
    int hire_year;

    public Employee(String n, int s, int hy){
        name= n;
        salary= s;
        hire_year=hy;
    }

    public double calAS(){
        return salary*12;
    }

    public int calSp(){
        return 2024 - hire_year ;
    }
}
