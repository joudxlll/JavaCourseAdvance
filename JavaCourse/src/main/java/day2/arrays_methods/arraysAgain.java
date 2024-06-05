package day2.arrays_methods;

import java.util.Arrays;

public class arraysAgain {
    public static void main(String[] args) {
        int[] xArr ={10,20,30};
        int[] yArr =xArr;

        int[] zArr =Arrays.copyOf(xArr,xArr.length);

        System.out.println(Arrays.toString(xArr));
        System.out.println(Arrays.toString(yArr));
        System.out.println(Arrays.toString(zArr));

        yArr[1] +=3;
        xArr[1] +=3;
//x and y has the same array location so if x or y change the array the changes are on one array
        System.out.println(Arrays.toString(xArr));
        System.out.println(Arrays.toString(yArr));
        System.out.println(Arrays.toString(zArr));

    }
}
