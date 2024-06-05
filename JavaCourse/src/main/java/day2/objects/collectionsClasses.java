package day2.objects;

import java.util.ArrayList;

public class collectionsClasses {
    public static void main(String[] args) {
        var marks = new ArrayList<Integer>();
        marks.add(22);
        marks.add(43);
        marks.add(26);
        marks.add(68);
        marks.add(43);
        marks.add(66);

        System.out.println(marks);
        System.out.println(marks.get(1));
        marks.add(1,11);
        System.out.println(marks);
        marks.set(1,88);
        System.out.println(marks);



    }
}
