package day4.Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDeleteDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\day4\\hr.db";
        String query = "delete from departments where department_id = ?";
        Scanner sc =new Scanner(System.in);


        try(Connection conn= DriverManager.getConnection(url);) {
            PreparedStatement st = conn.prepareStatement(query);
            System.out.println("Enter department ID: ");
            int depId = sc.nextInt();
            st.setInt(1,depId); // 1 is the first ?
            sc.nextLine();

            int rows = st.executeUpdate(); //return the rows that are affected


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
