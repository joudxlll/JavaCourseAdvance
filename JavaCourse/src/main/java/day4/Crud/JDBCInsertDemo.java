package day4.Crud;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsertDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\day4\\hr.db";
        String query = "insert into departments values (?,?,?)";
        Scanner sc =new Scanner(System.in);


        try(Connection conn= DriverManager.getConnection(url);) {
            PreparedStatement st = conn.prepareStatement(query);
            System.out.println("Enter department ID: ");
            int depId = sc.nextInt();
            st.setInt(1,depId); // 1 is the first ?
            sc.nextLine();

            System.out.println("Enter department Name: ");
            String depName = sc.nextLine();
            st.setString(2,depName); // second is the first ?

            System.out.println("Enter department Location: ");
            int locId = sc.nextInt();
            st.setInt(3,locId); // second is the first ?
            sc.nextLine();


            int rows = st.executeUpdate(); //return the rows that are affected


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
