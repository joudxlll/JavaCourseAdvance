package org.example.dto;

import jakarta.ws.rs.QueryParam;

public class DoctorFilterDTO {
    private @QueryParam("consultation_status") String consultation_status;
    private @QueryParam("doctor_id") Integer doctor_id ;
    private @QueryParam("doctor_name") String doctor_name;
    private @QueryParam("doctor_specialty") String doctor_specialty;
    private @QueryParam("consultation_rate") Integer consultation_rate;
    private @QueryParam("isAvailable") Boolean isAvailable;


    public String getConsultation_status() {
        return consultation_status;
    }

    public void setConsultation_status(String consultation_status) {
        this.consultation_status = consultation_status;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
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

    public Integer getConsultation_rate() {
        return consultation_rate;
    }

    public void setConsultation_rate(Integer consultation_rate) {
        this.consultation_rate = consultation_rate;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
