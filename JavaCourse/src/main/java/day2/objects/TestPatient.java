package day2.objects;

public class TestPatient {
    public static void main(String[] args) {
        Patient x = new Patient("joud",57,160);

        System.out.println(x.name);
        System.out.println(x.calcBMI());
        System.out.println(x.getStatus());


    }
}
