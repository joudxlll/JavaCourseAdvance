package org.example.dto;

import jakarta.ws.rs.QueryParam;


public class EmployeeFilterDto {
    private @QueryParam("hireDate") String hireDate;
    private @QueryParam("jobId") Integer jobId;

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}
