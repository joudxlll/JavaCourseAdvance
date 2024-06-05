package day1.if_switch;

import java.util.Scanner;

public class quiz {
    public static void main(String[] args) {
        int x= (int) (Math.random() * 10);
        int y= (int) (Math.random() * 10);

        Scanner sc =new Scanner(System.in);

        double xx= Math.random() * 10;

        System.out.printf("what is %d * %d",x ,y);
        int answer = sc.nextInt();
        if(answer == x*y){
            System.out.println("answer is correct");
        }
        else{
            System.out.println("answer is wrong");
        }

    }
}
