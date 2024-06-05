package day3.inhe_poly;

public class Course implements Comparable<Course>{
    private String title;
    private double price;

    public Course(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Course o) {
        if(price>o.price){
            return 1;
        } else if (price == o.price) {
            return 0;
        }
        else
        return -1;
    }

    @Override
    public String toString(){
        return "course{"+ title + "'\'" +"price= "+ price+ "}";
    }
}
