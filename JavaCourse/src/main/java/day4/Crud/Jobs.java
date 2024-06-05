package day4.Crud;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Jobs {
    private int job_id;
    private String job_title;
    private double job_salary;

    public Jobs(int job_id, String job_title, double job_salary) {
        this.job_id = job_id;
        this.job_title = job_title;
        this.job_salary = job_salary;
    }

    public Jobs(ResultSet rs) throws SQLException {
        job_id = rs.getInt("job_id");
        job_title = rs.getString("job_title");
        job_salary = rs.getDouble("min_salary");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "job_id=" + job_id +
                ", job_title='" + job_title + '\'' +
                ", job_salary=" + job_salary +
                '}';
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public double getJob_salary() {
        return job_salary;
    }

    public void setJob_salary(double job_salary) {
        this.job_salary = job_salary;
    }
}
