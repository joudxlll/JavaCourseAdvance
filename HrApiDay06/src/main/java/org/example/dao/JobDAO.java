package org.example.dao;

import org.example.dto.JobFilterDto;
import org.example.models.Jobs;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO {

    private static final String URL = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\JavaCourse\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_Jobd = "select * from jobs";

    private static final String SELECT_MINSALARY_Jobd = "select * from jobs where min_salary = ?";
    private static final String SELECT_JOB_WITH_LIMIT_OFFSET = "select * from jobs order by job_id limit ? offset ?";
    private static final String SELECT_DEPT_WITH_PAGINATION = "select * from departments order by department_id limit ? offset ?";

    private static final String SELECT_ONE_Jobs = "select * from jobs where job_id = ?";
    private static final String INSERT_Jobs = "insert into jobs values (?, ?, ?)";
    private static final String UPDATE_Jobs = "update jobs set job_title = ?, job_id = ? where job_id = ?";
    private static final String DELETE_Jobs = "delete from jobs where job_id = ?";
    private static final String DELETE_MINSALARYJobs = "delete from jobs where min_salary = ?";


    public void inserjob(Jobs d) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_Jobs);
        st.setInt(1, d.getJob_id());
        st.setString(2, d.getJob_title());
        st.setDouble(3, d.getJob_Minsalary());
        st.executeUpdate();
    }

    public void updatejob(Jobs d) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_Jobs);
        st.setInt(3, d.getJob_id());
        st.setString(1, d.getJob_title());
        st.setDouble(2, d.getJob_Minsalary());
        st.executeUpdate();
    }

    public void deletejob(int jobtId) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_Jobs);
        st.setInt(1, jobtId);
        st.executeUpdate();
    }

    public Jobs selectjob(int jobId) throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_Jobs);
        st.setInt(1, jobId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Jobs(rs);
        }
        else {
            return null;
        }
    }

//    public ArrayList<Jobs> selectAlljob(Double misaliry) throws SQLException {
//        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(SELECT_ALL_Jobd);
//        ResultSet rs = st.executeQuery();
//        ArrayList<Jobs> jobs = new ArrayList<>();
//        while (rs.next()) {
//            jobs.add(new Jobs(rs));
//        }
//
//        return jobs;
//    }

    public ArrayList<Jobs> selectAlljob(JobFilterDto filter) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(filter.getMinsalary() != null) {
            st = conn.prepareStatement(SELECT_MINSALARY_Jobd);
            st.setDouble(1, filter.getMinsalary());
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_Jobd);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Jobs> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new Jobs(rs));
        }

        return jobs;
    }

}