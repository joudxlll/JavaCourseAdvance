package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorConsultationScheduleDTO {
    private int doctor_id;
    private String doctor_name;
    private String doctor_specialty;
    private int consultation_rate;
    private boolean isAvailable;

    public DoctorConsultationScheduleDTO(int doctor_id, String doctor_name, String doctor_specialty, int consultation_rate, boolean isAvailable) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_specialty = doctor_specialty;
        this.consultation_rate = consultation_rate;
        this.isAvailable = isAvailable;

    }

    public DoctorConsultationScheduleDTO(ResultSet rs) throws SQLException {
        doctor_id = rs.getInt("doctor_id");
        doctor_name = rs.getString("doctor_name");
        doctor_specialty = rs.getString("doctor_specialty");
        consultation_rate = rs.getInt("consultation_rate");
        isAvailable = rs.getBoolean("isAvailable");
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getConsultation_rate() {
        return consultation_rate;
    }

    public void setConsultation_rate(int consultation_rate) {
        this.consultation_rate = consultation_rate;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_specialty() {
        return doctor_specialty;
    }

    public void setDoctor_specialty(String doctor_specialty) {
        this.doctor_specialty = doctor_specialty;
    }
    @Override
    public String toString() {
        return "Doctors{" +
                "doctor_id=" + doctor_id +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_specialty='" + doctor_specialty + '\'' +
                '}';
    }
}
