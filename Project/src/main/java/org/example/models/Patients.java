package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class Patients {
    private int patient_id;
    private String patient_name;
    private String patient_email;
    private String patient_password;
    private int patient_phone;
    private LocalDate patient_dateOfBirth;

    public Patients(){

    }
    public Patients(int patient_id, String patient_name, String patient_email, String patient_password, int patient_phone, LocalDate patient_dateOfBirth) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_email = patient_email;
        this.patient_password = patient_password;
        this.patient_phone = patient_phone;
        this.patient_dateOfBirth = patient_dateOfBirth;
    }

    public Patients(ResultSet rs) throws SQLException {
        patient_id = rs.getInt("patient_id");
        patient_name = rs.getString("patient_name");
        patient_email = rs.getString("patient_email");
        patient_password = rs.getString("patient_password");
        patient_phone = rs.getInt("patient_phone");
        String dateOfBirthString = rs.getString("patient_dateOfBirth");
        patient_dateOfBirth = LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    }
    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getPatient_password() {
        return patient_password;
    }

    public void setPatient_password(String patient_password) {
        this.patient_password = patient_password;
    }

    public int getPatient_phone() {
        return patient_phone;
    }

    public void setPatient_phone(int patient_phone) {
        this.patient_phone = patient_phone;
    }

    public LocalDate getPatient_dateOfBirth() {
        return patient_dateOfBirth;
    }

    public void setPatient_dateOfBirth(LocalDate patient_dateOfBirth) {
        this.patient_dateOfBirth = patient_dateOfBirth;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", patient_name='" + patient_name + '\'' +
                ", patient_email='" + patient_email + '\'' +
                ", patient_password='" + patient_password + '\'' +
                ", patient_phone=" + patient_phone +
                ", patient_dateOfBirth=" + patient_dateOfBirth +
                '}';
    }
}
