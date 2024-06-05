package day2.objects;

public class Student {
    String name;
    private double mark;
    static int fullMark;

    public Student(String n, double m){
        name=n;
        mark=m;
    }

    public  double grtPercent(){
        return mark/ fullMark * 100;
    }

    public String getGrade(){
        double pct= grtPercent();
        if(pct <18.5)
            return "underweight";
        else if(pct <25)
            return "normal";
        else if(pct <30)
            return "overweight";

        else return "fail";
    }

    public double getMark(){
        return mark;
    }

    public void setMark(double value){
        if(value >= 0){
            mark = value;
        }
    }
}
