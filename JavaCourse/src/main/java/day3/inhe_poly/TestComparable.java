package day3.inhe_poly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestComparable {
    public static void main(String[] args) {
        var markList = new ArrayList<Double>();
        markList.add(23.5);
        markList.add(20.0);
        markList.add(25.0);

    var nameList = new ArrayList<String>();
        nameList.add("Joud");
        nameList.add("Noura");
        nameList.add("Khalid");

        Collections.sort(markList);
        Collections.sort(nameList);

        System.out.println(markList);
        System.out.println(nameList);

    var coursesList = new ArrayList<Course>();
    coursesList.add(new Course("Java",1500));
    coursesList.add(new Course("Python",500));
    coursesList.add(new Course("C#",2000));

    Collections.sort(coursesList);
        System.out.println(coursesList);
    }
}
