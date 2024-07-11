package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Consultations {
    private int consultation_id;
    private int doctor_id;
    private int patient_id;
    private LocalDateTime consultation_requestTime;
    private LocalDateTime consultation_time;
    private String consultation_status;
    private String consultation_diagnosis;
    private int consultation_rate;

    public Consultations(){

    }
    public Consultations(int consultation_id, int doctor_id, int patient_id, LocalDateTime consultation_requestTime, LocalDateTime consultation_time, String consultation_status, String consultation_diagnosis, int consultation_rate) {
        this.consultation_id = consultation_id;
        this.doctor_id = doctor_id;
        this.patient_id = patient_id;
        this.consultation_requestTime = consultation_requestTime;
        this.consultation_time = consultation_time;
        this.consultation_status = consultation_status;
        this.consultation_diagnosis = consultation_diagnosis;
        this.consultation_rate = consultation_rate;
    }

    public Consultations(ResultSet rs) throws SQLException {
        consultation_id = rs.getInt("consultation_id");
        doctor_id = rs.getInt("doctor_id");
        patient_id = rs.getInt("patient_id");
        consultation_requestTime = LocalDateTime.parse(rs.getString("consultation_requestTime"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // Handle null consultation_time
        String consultationTimeStr = rs.getString("consultation_time");
        consultation_time = (consultationTimeStr != null) ? LocalDateTime.parse(consultationTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : null;

        consultation_status = rs.getString("consultation_status");
        consultation_diagnosis = rs.getString("consultation_diagnosis");
        consultation_rate = rs.getInt("consultation_rate");
    }

    public int getConsultation_id() {
        return consultation_id;
    }

    public void setConsultation_id(int consultation_id) {
        this.consultation_id = consultation_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public LocalDateTime getConsultation_requestTime() {
        return consultation_requestTime;
    }

    public void setConsultation_requestTime(LocalDateTime consultation_requestTime) {
        this.consultation_requestTime = consultation_requestTime;
    }

    public LocalDateTime getConsultation_time() {
        return consultation_time;
    }

    public void setConsultation_time(LocalDateTime consultation_time) {
        this.consultation_time = consultation_time;
    }

    public String getConsultation_status() {
        return consultation_status;
    }

    public void setConsultation_status(String consultation_status) {
        this.consultation_status = consultation_status;
    }

    public String getConsultation_diagnosis() {
        return consultation_diagnosis;
    }

    public void setConsultation_diagnosis(String consultation_diagnosis) {
        this.consultation_diagnosis = consultation_diagnosis;
    }

    public int getConsultation_rate() {
        return consultation_rate;
    }

    public void setConsultation_rate(int consultation_rate) {
        this.consultation_rate = consultation_rate;
    }

    @Override
    public String toString() {
        return "Consultations{" +
                "consultation_id=" + consultation_id +
                ", doctor_id=" + doctor_id +
                ", patient_id=" + patient_id +
                ", consultation_requestTime=" + consultation_requestTime +
                ", consultation_time=" + consultation_time +
                ", consultation_status='" + consultation_status + '\'' +
                ", consultation_diagnosis='" + consultation_diagnosis + '\'' +
                ", consultation_rate=" + consultation_rate +
                '}';
    }
}

