package day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsertDemoV3 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\day4\\hr.db";
        String query = "insert into departments values (?,?,?)";
        Scanner sc =new Scanner(System.in);


        try(Connection conn= DriverManager.getConnection(url);) {
            conn.setAutoCommit(false); //wait for confirmation

            PreparedStatement st = conn.prepareStatement(query); //out of the loop so its only one object (batch)
            while (true) {

                System.out.println("Enter department ID: ");
                int depId = sc.nextInt();
                st.setInt(1, depId); // 1 is the first ?
                sc.nextLine();

                System.out.println("Enter department Name: ");
                String depName = sc.nextLine();
                st.setString(2, depName); // second is the first ?

                System.out.println("Enter department Location: ");
                int locId = sc.nextInt();
                st.setInt(3, locId); // second is the first ?

                st.addBatch();

                sc.nextLine();
                System.out.println("Do you want to save: ");
                String toSave = sc.nextLine();
                if(toSave.equals("yes")){
                    int[] rows = st.executeBatch();
                    for (int r : rows) {
                        System.out.println(r + " inserted");
                    }
                    conn.commit();
                    System.out.println("data saved");
                    break;
                } else if (toSave.equals("no")) {
                    conn.rollback();
                    System.out.println("save cancelled");
                    break;
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
