package day1.if_switch;

import java.util.Scanner;

public class checkDay {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a day number:");
        int day = sc.nextInt();

        if(day >= 1 && day <= 5){
            System.out.println("work-day");
        }
        else if(day ==6 || day == 7){
            System.out.println("off-day");
        }
        else{
            System.out.println("invalid input");

        }

        switch (day){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("wednesday");
                break;
            case 5:
                System.out.println("thursday");
                break;
            case 6:
                System.out.println("friday");
                break;
            case 7:
                System.out.println("saturday");
                break;
            default:
                System.out.println("not a day");

        }

        switch (day){ //no break needed
            case 1->
                System.out.println("Sunday");
            case 2->
                System.out.println("Monday");
            case 3->
                System.out.println("Tuesday");
            case 4->
                System.out.println("wednesday");
            case 5->
                System.out.println("thursday");
            case 6->
                System.out.println("friday");
            case 7->
                System.out.println("saturday");
            default->
                System.out.println("not a day");

        }

        String dayName = switch (day){ //no break needed
            case 1-> ("Sunday");
            case 2-> ("Monday");
            case 3-> ("Tuesday");
            case 4-> ("wednesday");
            case 5-> ("thursday");
            case 6-> ("friday");
            case 7-> ("saturday");
            default-> ("not a day");
        };

        String dayName2 = switch (day){ //no break needed
            case 1: yield  ("Sunday");
            case 2: yield("Monday");
            case 3: yield("Tuesday");
            case 4: yield("wednesday");
            case 5: yield("thursday");
            case 6: yield ("friday");
            case 7: yield("saturday");
            default: yield("not a day");
        };
    }
}
