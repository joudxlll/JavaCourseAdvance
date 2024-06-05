package day1.Excercises;

import java.util.Scanner;

public class quiz2_EX3 {    public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);

    int x= (int) (Math.random() * 10);
    int y= (int) (Math.random() * 10);

    System.out.printf("what is %d * %d",x ,y);
    int answer = sc.nextInt();

    while(answer != x*y){
        System.out.println("try again");
        answer = sc.nextInt();

    }
    System.out.println("answer is Correct");

}

}
