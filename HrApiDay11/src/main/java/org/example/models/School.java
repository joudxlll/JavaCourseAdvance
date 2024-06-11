package org.example.models;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class School {
    private ArrayList<Student> students;

    public School() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student c) {
        students.add(c);
    }

    public void removeStudent(int id) {
        for (Student c : students) {
            if(c.getStudentId() == id) {
                students.remove(c);
                return;
            }
        }
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void sortStudentsByName() {
        Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    public void sortStudentsById() {
        Collections.sort(students, Comparator.comparingInt(Student::getStudentId));
    }


    public Student findStudentByIdBinarySearch(int studentId) {
        int left = 0;
        int right = students.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = students.get(mid).getStudentId();

            if (midId == studentId) {
                return students.get(mid);
            } else if (midId < studentId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }


    public void listOfStudentFile(String fileName) {
        try {
            File myObj = new File(fileName+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(fileName+".txt");
            for(Student Stu: students){
                myWriter.write(Stu.getDetails()+System.lineSeparator());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readStudentsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Checking if the line contains all expected details
                if (!line.contains("First Person Name:") || !line.contains("Age:") || !line.contains("Address:") || !line.contains("Course:") || !line.contains("Student ID:")) {
                    System.err.println("Error: Line does not contain all expected details. Skipping.");
                    continue; // Skip this line and proceed to the next one
                }

                // Extracting details using a more robust approach
                String[] parts = line.split(":"); // part[0] First Person Name
                String name = parts[1].trim().split("\\s+")[0];
                int age = Integer.parseInt(parts[2].trim().split("\\s+")[0]);
                String address = parts[3].trim().split("\\s+")[0];
                String course = parts[4].trim().split("\\s+")[0];
                int studentId = Integer.parseInt(parts[5].trim().split("\\s+")[0]);

                // Creating a new student object and adding it to the list
                Student student = new Student(name, age, address, studentId, course);
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file " + filename + " was not found.");
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in file: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        School school = new School();
        Student s1 = new Student("Joud", 20, "Riyadh", 1001, "Computer Science");
        Student s2 = new Student("Ali", 22, "Qassim", 1002, "Mathematics");
        Student s3 = new Student("Nour", 25, "Jeddah", 1003, "Physics");
        Student s4 = new Student("Khalid", 24, "Riyadh", 1004, "Biology");
        Student s5 = new Student("Lolo", 21, "Riyadh", 1005, "Chemistry");

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);
        school.addStudent(s4);
        school.addStudent(s5);

        System.out.println("Before deleting:");
        school.displayAllStudents();

        System.out.println("\nAfter deleting ID 1005:");
        school.removeStudent(1005);
        school.displayAllStudents();

        System.out.println("\n\nBefore sorting:");
        school.displayAllStudents();

        school.sortStudentsByName();

        System.out.println("\nAfter sorting:");
        school.displayAllStudents();

        System.out.println("\nCreat A students file and writing on it:");
        school.listOfStudentFile("students");

        System.out.println("\nFind Student by ID using Binary Search:");
        school.sortStudentsById();
        Student foundStudent = school.findStudentByIdBinarySearch(1003);
        if (foundStudent != null) {
            System.out.println("Student with ID:1003" + " found: " + foundStudent);
        } else {
            System.out.println("Student with ID:1003 "+ " not found.");
        }

        System.out.println("\nread students from the text file and populate the ArrayList of students:");
        School newSchool = new School();
        newSchool.readStudentsFromFile("students.txt");
        newSchool.displayAllStudents();

    }


}