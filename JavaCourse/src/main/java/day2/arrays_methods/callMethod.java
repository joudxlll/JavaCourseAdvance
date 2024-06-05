package day2.arrays_methods;

import java.util.Arrays;

public class callMethod {
    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        System.out.println("Enter weight and height: ");
//        double w = sc.nextDouble();
//        double h = sc.nextDouble();
//
//        double bmi =myMethods.calculateDMI(w,h);
//        String status = myMethods.getStatus(bmi);
//
//        System.out.println("your Bmi"+ + bmi + ", " + status);

        var statuses= myMethods.getStatus2(new double[] {23,20,35,15});
        System.out.println(Arrays.toString(statuses));

    }


}
