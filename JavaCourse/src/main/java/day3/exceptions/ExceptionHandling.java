package day3.exceptions;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) throws Exception {
        Student s = new Student("Joud",50);

        try{
            s.setMark(-100);
        }
        catch (invalidMarkException e){
            System.out.println("Recheck the mark");
        }
        //        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number");
//
//        try{
//            printResult();
//        }
//        catch (Exception e){
//            System.out.println("Recheck the input");
//        }
//        try {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//
//            System.out.println("Result: " + x / y);
//        }
//        catch (Exception e){
//            System.out.println("Recheck the input");
//        }
//        catch (ArithmeticException e){
//            System.out.println("cant devide by zero");
//        }
//        catch (InputMismatchException e){
//            System.out.println("only int are allowed");
//        }
    }

    public static void printResult()throws Exception{
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("Result: " + x / y);

    }
}
