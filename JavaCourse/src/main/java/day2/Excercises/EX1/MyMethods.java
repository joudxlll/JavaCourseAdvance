package day2.Excercises.EX1;
public class MyMethods{
    public static double calculatePCT(double mark, double fullMark){
        return (mark/fullMark)*100;
    }

    public static String getPCT(double ptc){
        if(ptc >85)
            return "Excellent";
        else if(ptc>75)
            return "Very Good";
        else if(ptc >30)
            return "Good";
        else if(ptc >=50)
            return "Pass";

        else return "Fail";

    }
}
