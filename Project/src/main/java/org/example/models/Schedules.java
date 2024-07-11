package org.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedules {
    private int schedule_id;
    private int doctor_id; // Changed to Integer
    private LocalDateTime schedule_startTime;
    private LocalDateTime schedule_endTime;
    private boolean isAvailable;

    public Schedules(){

    }

    public Schedules(int schedule_id, int doctor_id, LocalDateTime schedule_startTime, LocalDateTime schedule_endTime, boolean isAvailable) {
        this.schedule_id = schedule_id;
        this.doctor_id = doctor_id;
        this.schedule_startTime = schedule_startTime;
        this.schedule_endTime = schedule_endTime;
        this.isAvailable = isAvailable;
    }

    public Schedules(ResultSet rs) throws SQLException {
        schedule_id = rs.getInt("schedule_id");
        doctor_id = rs.getInt("doctor_id");
//        schedule_startTime = rs.getTimestamp("schedule_startTime").toLocalDateTime();
//        schedule_endTime = rs.getTimestamp("schedule_endTime").toLocalDateTime();
        schedule_startTime = rs.getObject("schedule_startTime", LocalDateTime.class);
        schedule_endTime = rs.getObject("schedule_endTime", LocalDateTime.class);
        isAvailable = rs.getBoolean("isAvailable");
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public LocalDateTime getSchedule_startTime() {
        return schedule_startTime;
    }

    public void setSchedule_startTime(LocalDateTime schedule_startTime) {
        this.schedule_startTime = schedule_startTime;
    }

    public LocalDateTime getSchedule_endTime() {
        return schedule_endTime;
    }

    public void setSchedule_endTime(LocalDateTime schedule_endTime) {
        this.schedule_endTime = schedule_endTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Schedules{" +
                "schedule_id=" + schedule_id +
                ", doctor_id=" + doctor_id +
                ", schedule_startTime=" + schedule_startTime +
                ", schedule_endTime=" + schedule_endTime +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

