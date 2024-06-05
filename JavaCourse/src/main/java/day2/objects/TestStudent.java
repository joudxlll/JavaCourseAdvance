package day2.objects;

public class TestStudent {
    public static void main(String[] args) {
        var s1= new Student("joud",66);
        var s2= new Student("Shoug",40);

        Student.fullMark=100;
        s1.setMark(-77);

        System.out.println(s1.name);
        System.out.println(s1.getMark());
        System.out.println(s1.grtPercent());
        System.out.println(s1.getGrade());
        System.out.println(Student.fullMark);



    }
}
