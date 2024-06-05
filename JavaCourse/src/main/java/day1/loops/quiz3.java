package day1.loops;

import java.util.Scanner;

public class quiz3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int correct = 0;
    for(int i=1; i<=5;i++){
        int x= (int) (Math.random() * 10);
        int y= (int) (Math.random() * 10);
        for(int j=1; j<=3;j++) {
            System.out.printf("what is %d * %d",x ,y);
            int answer = sc.nextInt();
            if(answer == x*y){
                System.out.println("correct");
                correct++;
                break;
            }
            else{
                System.out.println("wrong");
            }
        }
    }
        System.out.println("-----------------------------\n your score is:"+ correct + " out of 5");



    }
}
