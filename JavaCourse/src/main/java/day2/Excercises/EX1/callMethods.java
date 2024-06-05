package day2.Excercises.EX1;

import java.util.Scanner;

public class callMethods {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter mark and fullmark: ");
        double mark = sc.nextDouble();
        double fullMark = sc.nextDouble();

        double ptc = MyMethods.calculatePCT(mark, fullMark);
        String status = MyMethods.getPCT(ptc);

        System.out.println("your ptc"+ +ptc + ", " + status);


    }
}
