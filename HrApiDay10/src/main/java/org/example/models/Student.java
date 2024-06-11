package org.example.models;

import java.util.Objects;

public class Student extends Person implements ComparableById{
    private int StudentId;
    private String Course;

    public Student(String name, int age, String address, int studentId, String course) {
        super(name, age, address);
        StudentId = studentId;
        Course = course;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        if(studentId>0){
            StudentId = studentId;
        }
        else{
            System.out.println("Positivity only!");
        }
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    @Override
    public String toString(){
        return "First Person Name: "+getName()+ "    Age: "+getAge()+"   Address: "+ getAddress()+ "   Course: " + getCourse()+ "  Student ID: "+ getStudentId();
    }

    @Override
    public String getDetails(){
        return toString();
    }

    public boolean compareById(int id){
        if(getStudentId()==id){
            return true;
        }
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return StudentId == student.StudentId && Objects.equals(Course, student.Course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentId, Course);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Joud", 20, "Riyadh", 1001, "Computer Science");
        s1.setStudentId(-1);

        System.out.println(s1.compareById(1002));

    }
}