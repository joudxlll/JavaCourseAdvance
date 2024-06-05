package day4.Crud;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\day4\\hr.db";
        String query = "Select * from departments ";
        String query2 = "Select * from jobs";

        try(Connection conn= DriverManager.getConnection(url);) {
            Statement st = conn.createStatement();
            Statement st2 = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            ResultSet rs2 = st2.executeQuery(query2);

            while(rs.next()){
                Department d=new Department(rs);
                System.out.println(d); //toString
//                int depId = rs.getInt(1); // 1 the index of department_id column
//                String depName = rs.getString(2);
//                System.out.println(depId + ", "+ depName);
            }

            while (rs2.next()){
                Jobs e = new Jobs(rs2);
                System.out.println(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
