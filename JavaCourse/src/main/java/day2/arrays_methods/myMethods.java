package day2.arrays_methods;

public class myMethods {

    public static double calculateDMI(double height, double weight){
        return weight/Math.pow(height/100, 2);
    }

    public static String getStatus(double BMI){
        if(BMI <18.5)
            return "underweight";
        else if(BMI <25)
            return "normal";
        else if(BMI <30)
            return "overweight";

        else return "obese";

    }

    public static String[] getStatus2(double[] BMIs){
        var statuses = new String[BMIs.length];
        for(int i = 0; i< BMIs.length; i++){
            var bmi= BMIs[i];
            if(bmi <18.5)
                statuses[i]= "underweight";
            else if(bmi <25)
                statuses[i]= "normal";
            else if(bmi <30)
                statuses[i]= "overweight";

            else statuses[i]= "obese";
        }
        return statuses;

    }


}
