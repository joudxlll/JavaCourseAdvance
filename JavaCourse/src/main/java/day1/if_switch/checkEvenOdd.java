package day1.if_switch;

import java.util.Scanner;

public class checkEvenOdd {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a number:");
        int x = sc.nextInt();

        System.out.println(x % 2 == 0? "even": "odd");
    }
}
