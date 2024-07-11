package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Medical_ReportsDTO {
    private int MR_id;
    private int patient_id; // Changed to Integer
    private String MR_details;
    private Date MR_reportDate;

    public Medical_ReportsDTO(int MR_id, int patient_id, String MR_details, Date MR_reportDate) {
        this.MR_id = MR_id;
        this.patient_id = patient_id;
        this.MR_details = MR_details;
        this.MR_reportDate = MR_reportDate;
    }

    public Medical_ReportsDTO(ResultSet rs) throws SQLException {
        MR_id = rs.getInt("MR_id");
        patient_id = rs.getInt("patient_id");
        MR_details = rs.getString("MR_details");
        MR_reportDate = rs.getTimestamp("MR_reportDate");
    }

    public int getMR_id() {
        return MR_id;
    }

    public void setMR_id(int MR_id) {
        this.MR_id = MR_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getMR_details() {
        return MR_details;
    }

    public void setMR_details(String MR_details) {
        this.MR_details = MR_details;
    }

    public Date getMR_reportDate() {
        return MR_reportDate;
    }

    public void setMR_reportDate(Date MR_reportDate) {
        this.MR_reportDate = MR_reportDate;
    }

    @Override
    public String toString() {
        return "Medical_Reports{" +
                "MR_id=" + MR_id +
                ", patient_id=" + patient_id +
                ", MR_details='" + MR_details + '\'' +
                ", MR_reportDate=" + MR_reportDate +
                '}';
    }
}
