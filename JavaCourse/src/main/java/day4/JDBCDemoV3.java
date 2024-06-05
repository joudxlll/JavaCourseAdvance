package day4;

import day4.Crud.Department;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemoV3 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\day4\\hr.db";
        String query = "Select * from departments where location_id = ?"; //? is variable
        Scanner sc =new Scanner(System.in);
//        System.out.println("Enter location ID: ");
//        int locId = sc.nextInt();
//        query += locId;

        try(Connection conn= ConnPoolConfig.getConnection();) {
//            Statement st = conn.createStatement();  // the statment is ready to use
            PreparedStatement st = conn.prepareStatement(query); //prepare the statment not done yet
            System.out.println("Enter location ID: ");
            int locId = sc.nextInt();
            st.setInt(1,locId); // 1 is the first ?
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                Department d=new Department(rs);
                System.out.println(d); //toString
//                int depId = rs.getInt(1); // 1 the index of department_id column
//                String depName = rs.getString(2);
//                System.out.println(depId + ", "+ depName);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
