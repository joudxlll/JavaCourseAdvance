package day1.strings_array;

public class stringBasic {
    public static void main(String[] args) {
        String name= "joud";
        String phone= "0553499884";
        String email= "joud_alrumayh@hotmail.com";
        String message= "hello";

        System.out.println(name.length());
        System.out.println(name.charAt(1));
        System.out.println(name.substring(0,2));

        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());

        System.out.println(email.endsWith("com"));
        System.out.println(email.startsWith("jo"));
        System.out.println(email.contains("ru"));

        char A ='e';
        System.out.println(Character.isDigit(A));
        System.out.println(Character.isUpperCase(A));




    }
}
