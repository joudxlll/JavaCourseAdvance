package day1.Excercises;

import java.util.Scanner;

public class checkDay_EX1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a day number:");
        int day = sc.nextInt();

//        switch (day){ //no break needed
//            case 1->
//                    System.out.println("Work day");
//            case 2->
//                    System.out.println("Work day");
//            case 3->
//                    System.out.println("Work day");
//            case 4->
//                    System.out.println("Work day");
//            case 5->
//                    System.out.println("off-day");
//            case 6->
//                    System.out.println("off-day");
//            case 7->
//                    System.out.println("Work day");
//            default->
//                    System.out.println("not a day");
//
//        }

        if(day>=1 &&day <= 4 || day == 7){
            System.out.println("work-day");
        }
        else if(day ==6 || day == 5){
            System.out.println("off-day");
        }
        else{
            System.out.println("invalid input");

        }
    }
}
