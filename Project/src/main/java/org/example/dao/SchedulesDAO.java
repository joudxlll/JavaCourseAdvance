package org.example.dao;


import org.example.controller.DatabaseConfig;
import org.example.models.Schedules;

import java.sql.*;
import java.util.ArrayList;

public class SchedulesDAO {

    private static final String INSERT_SCHEDULE = "INSERT INTO SCHEDULES (doctor_id, schedule_startTime, schedule_endTime, isAvailable) VALUES (?,?,?,?)";
    private static final String UPDATE_SCHEDULE = "UPDATE SCHEDULES SET isAvailable = ? WHERE schedule_id = ?";
    private static final String SELECT_ALL_SCHEDULE = "SELECT * FROM SCHEDULES";
    private static final String SELECT_DOCTOR_SCHEDULE = "SELECT * FROM SCHEDULES WHERE doctor_id = ?";


    public void insertSch(Schedules s) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(INSERT_SCHEDULE);
        st.setInt(1, s.getDoctor_id());
        st.setTimestamp(2, Timestamp.valueOf(s.getSchedule_startTime()));
        st.setTimestamp(3, Timestamp.valueOf(s.getSchedule_endTime()));
//        st.setString(2,s.getSchedule_startTime().toString());
//        st.setString(3,s.getSchedule_endTime().toString());

        st.setBoolean(4, s.isAvailable());
        st.executeUpdate();
        conn.close();
    }

    public void updateSch(Schedules s) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(UPDATE_SCHEDULE);
//        st.setTimestamp(1,Timestamp.valueOf(s.getSchedule_startTime()));
//        st.setTimestamp(2,Timestamp.valueOf(s.getSchedule_endTime()));
        st.setBoolean(1, s.isAvailable());
        st.setInt(2, s.getSchedule_id());



        st.executeUpdate();
        conn.close();
    }

    public ArrayList<Schedules> selectAllSch() throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(SELECT_ALL_SCHEDULE);

        ResultSet rs = st.executeQuery();
        ArrayList<Schedules> schedules = new ArrayList<>();
        while (rs.next()) {
            schedules.add(new Schedules(rs));
        }
        rs.close();
        conn.close();
        return schedules;
    }

    public Schedules selectDoctorSch(int docId) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(SELECT_DOCTOR_SCHEDULE);
        st.setInt(1, docId);

        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Schedules(rs);
        }
        else {
            return null;
        }


    }
















}
