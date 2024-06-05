package day1.strings_array;

import java.util.Scanner;

public class passwordChecker {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a new Password: ");
        String password = sc.nextLine();

        if(password.length() < 8){
            System.out.println("weak password");
        }
        else {
            int digitCount = 0;
            int upperCount = 0;
            for(int i=0; i<password.length(); i++){
                char c =password.charAt(i);
                if(Character.isUpperCase(c)){
                    upperCount++;
                }
                else if(Character.isDigit(c)){
                    digitCount++;
                }
            }
            if(upperCount<2 || digitCount<2){
                System.out.println("weak password");
            }
            else{
                System.out.println("strong password");

            }

        }
    }
}
