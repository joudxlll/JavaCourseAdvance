package org.example.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@XmlRootElement
public class EmployeeDto {

    private int employee_id;
    private String hire_date;
    private int job_id;
    private JobsDto job;

    private ArrayList<LinkDto> links = new ArrayList<>();

    public EmployeeDto() {
    }

    public EmployeeDto(String hire_date, int employee_id, int job_id, ArrayList<LinkDto> links) {
        this.hire_date = hire_date;
        this.employee_id = employee_id;
        this.job_id = job_id;
    }

    public EmployeeDto(ResultSet rs) throws SQLException {
        hire_date = rs.getString("hire_date");
        employee_id = rs.getInt("employee_id");
        job_id = rs.getInt("job_id");
    }
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public JobsDto getJob() {
        return job;
    }

    public void setJob(JobsDto job) {
        this.job = job;
    }

    @XmlElementWrapper
    @XmlElement(name = "link")
    public ArrayList<LinkDto> getLinks() {
        return links;
    }

    public void addLink(String url, String rel) {
        LinkDto link = new LinkDto();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employee_id=" + employee_id +
                ", hire_date='" + hire_date + '\'' +
                ", job_id=" + job_id +
                ", links=" + links +
                '}';
    }
}
