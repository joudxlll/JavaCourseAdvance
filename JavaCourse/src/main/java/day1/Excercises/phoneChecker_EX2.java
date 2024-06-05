package day1.Excercises;

import java.util.Scanner;

public class phoneChecker_EX2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a phone number: ");
        String phoneNumber = sc.nextLine();

        if(phoneNumber.length() != 10){
            System.out.println("phone number must be 10 digits");
        }
        else{
            if(!phoneNumber.startsWith("05")){
                System.out.println("must start with 05");
            }
            else {
                boolean flag = false;
                for (int i = 0; i < phoneNumber.length(); i++) {
                    char c = phoneNumber.charAt(i);
                    if (!Character.isDigit(c)) {
                        flag = true;
                    }
                }

                if (flag) {
                    System.out.println("must enter numbers only");
                } else {
                    System.out.println("phone number is correct");
                }
            }


            }
    }
}
