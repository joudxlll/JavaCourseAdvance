package day4.Excercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInserJobs {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\day4\\hr.db";
        String query = "insert into jobs values (?,?,?,?)";
        Scanner sc =new Scanner(System.in);


        try(Connection conn= DriverManager.getConnection(url);) {
            PreparedStatement st = conn.prepareStatement(query);
            System.out.println("Enter job ID: ");
            int jobId = sc.nextInt();
            st.setInt(1, jobId); // 1 is the first ?
            sc.nextLine();

            System.out.println("Enter job title: ");
            String jobTitle = sc.nextLine();
            st.setString(2, jobTitle); // second is the first ?

            System.out.println("Enter min salary: ");
            double minSalary = sc.nextInt();
            st.setDouble(3, minSalary); // second is the first ?
            sc.nextLine();

            System.out.println("Enter max salary: ");
            double maxSalary = sc.nextDouble();
            st.setDouble(4, minSalary); // second is the first ?
            sc.nextLine();


            int rows = st.executeUpdate(); //return the rows that are affected


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
