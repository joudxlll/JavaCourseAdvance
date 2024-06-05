package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.example.models.Employees;


public class EmployeeDAO {
    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_EMPS = "select * from employees";
    private static final String SELECT_ONE_EMP = "select * from employees where employee_id = ?";
    private static final String INSERT_EMP = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_EMP = "UPDATE employees set first_name = ?, last_name = ? WHERE employee_id = ?";
    private static final String DELETE_EMP = "delete from employees where employee_id = ?";


    public void insertEmp(Employees d) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_EMP);
        st.setInt(1, d.getEmployee_id()); //1 - 10
        st.setString(2, d.getFirst_name());
        st.setString(3, d.getLast_name());
        st.setString(4, d.getEmail());
        st.setString(5, d.getPhone_number());
        st.setString(6, d.getHire_date());
        st.setInt(7, d.getJob_id());
        st.setDouble(8, d.getSalary());
        st.setInt(9, d.getManager_id());
        st.setInt(10, d.getDepartment_id());

        st.executeUpdate();
    }

    public void updateEmp(Employees d) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_EMP);
        st.setInt(3, d.getEmployee_id());
        st.setString(1, d.getFirst_name());
        st.setString(2, d.getLast_name());
        st.executeUpdate();
    }

    public void deleteEmp(int EmpId) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_EMP);
        st.setInt(1, EmpId);
        st.executeUpdate();
    }

    public Employees selectEMP(int empId) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_EMP);
        st.setInt(1, empId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Employees(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Employees> selectAllEmps() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ALL_EMPS);
        ResultSet rs = st.executeQuery();
        ArrayList<Employees> emps = new ArrayList<>();
        while (rs.next()) {
            emps.add(new Employees(rs));
        }

        return emps;
    }
}
