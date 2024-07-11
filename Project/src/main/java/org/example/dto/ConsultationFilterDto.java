package org.example.dto;

import jakarta.ws.rs.QueryParam;


public class ConsultationFilterDto {
    private @QueryParam("doctor_id") String doctor_id;

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }
}
