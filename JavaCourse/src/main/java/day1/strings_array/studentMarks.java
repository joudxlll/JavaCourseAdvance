package day1.strings_array;

import java.util.Scanner;

public class studentMarks {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter number of student: ");
        int n = sc.nextInt();
        double[] Marks=new double[n];
        double best = 0;

        for(int i=0; i<n;i++){
            System.out.println("Enter student mark: ");
            Marks[i]= sc.nextInt();
            if(Marks[i] >=best)
                best = Marks[i];
        }

//        for(int z = 0; z <Marks.length; z++) {
//            if (Marks[z] >= best - 10)
//                System.out.println(Marks[z] + " => A");
//            else if (Marks[z] >= best - 20)
//                System.out.println(Marks[z] + " => B");
//            else if (Marks[z] >= best - 30)
//                System.out.println(Marks[z] + " => C");
//            else if (Marks[z] >= best - 40)
//                System.out.println(Marks[z] + " => D");
//            else
//                System.out.println(Marks[z] + " => F");
//        }

        for (double m : Marks) {
            if(m >= best - 10) {
                System.out.println(m + " => A");
            }
            else if(m >= best - 20) {
                System.out.println(m + " => B");
            }
            else if(m >= best - 30) {
                System.out.println(m + " => C");
            }
            else if(m >= best - 40) {
                System.out.println(m + " => D");
            }
            else {
                System.out.println(m + " => F");
            }

        }
    }
}
