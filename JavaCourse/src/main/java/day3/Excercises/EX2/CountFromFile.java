package day3.Excercises.EX2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CountFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        var fileName = new File("C:\\Users\\dev\\Desktop\\test2.txt");
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        Scanner sc = new Scanner(fileName);
        while (sc.hasNext()) {
            String words = sc.nextLine();
            System.out.println(words);
            for(var c: sc.nextLine().toLowerCase().toCharArray()){
                if (charMap.containsKey(c)){
                    charMap.put(c, charMap.get(c+1));
                }
                else {
                    charMap.put(c, 1);
                }
            }
        }
//        for()

    }
}
