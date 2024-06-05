package day3.inhe_poly;


public class TestEmployees {

    public static void main(String[] args) {
        Trainer t1 = new Trainer(101, "Wael", 10000);
        Course c1 = new Course("Java", 1500);
        Course c2 = new Course("Python", 1000);
        Course c3 = new Course("SQL", 1000);

        t1.addCourse(c1);
        t1.addCourse(c2);
        t1.addCourse(c3);

        System.out.println(t1.getCourses().size());
        System.out.println(t1.getCourses().get(0).getTitle());

        t1.removeCourse("SQL");
        System.out.println(t1.getCourses().size());

        SalesPerson s1 = new SalesPerson(102, "Fares", 10000, 0.1);

        System.out.println("--------------");
        System.out.println(t1.getName());
        System.out.println(t1.getTotalSalary());
        System.out.println(t1.getClass());
        System.out.println(t1);
        System.out.println("--------------");
        System.out.println(s1.getName());
        System.out.println(s1.getTotalSalary());

        printDetails(s1);



    }
    public static void printDetails(Employee e){
        System.out.println(e.getName());
        System.out.println(e.getAnualSalary());
        if(e instanceof Trainer){
            System.out.println(((Trainer) e).getTotalSalary());
        }
        else {
            System.out.println(((SalesPerson) e).getTotalSalary());
        }
    }
}
