package org.example.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@XmlRootElement
public class JobsDto {
    private int job_id;
    private String job_title;
    private double job_MinSalary;
    private double job_MaxSalary;


    private ArrayList<LinkDto> links = new ArrayList<>();

    public JobsDto(){

    }
    public JobsDto(int job_id, String job_title, double job_MinSalary, double job_MaxSalary) {
        this.job_id = job_id;
        this.job_title = job_title;
        this.job_MinSalary = job_MinSalary;
        this.job_MaxSalary = job_MaxSalary;

    }

    public JobsDto(ResultSet rs) throws SQLException {
        job_id = rs.getInt("job_id");
        job_title = rs.getString("job_title");
        job_MinSalary = rs.getDouble("min_salary");
        job_MaxSalary = rs.getDouble("max_salary");

    }

    @Override
    public String toString() {
        return "Employee{" +
                "job_id=" + job_id +
                ", job_title='" + job_title + '\'' +
                ", job_Minsalary=" + job_MinSalary +
                ", job_Maxsalary=" + job_MaxSalary +
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

    public double getJob_MaxSalary() {
        return job_MaxSalary;
    }

    public void setJob_MaxSalary(double job_MaxSalary) {
        this.job_MaxSalary = job_MaxSalary;
    }

    public double getJob_MinSalary() {
        return job_MinSalary;
    }

    public void setJob_MinSalary(double job_MinSalary) {
        this.job_MinSalary = job_MinSalary;
    }

    public ArrayList<LinkDto> getLinks() {
        return links;
    }

    public void addLink(String url, String rel) {
        LinkDto link = new LinkDto();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }
}
