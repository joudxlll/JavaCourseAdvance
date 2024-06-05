package day1.loops;

public class loopBasic {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        while (x<= 10){
            System.out.println(x + "\t");
            x++;
        }

        System.out.println("-----------------------------");

        do {
            System.out.println(y + "\t");
            y++;
        }while (y<=10);

        System.out.println("-----------------------------");
        for (int w=1; w<=10;w++){
            if(w==5)
                continue;
            System.out.println(w);
        }
    }
}
