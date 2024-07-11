package org.example.dao;

import org.example.controller.DatabaseConfig;
import org.example.dto.ConsultationFilterDto;
import org.example.dto.ConsultationsDTO;
import org.example.models.Consultations;

import java.sql.*;
import java.util.ArrayList;

public class ConsultationsDAO{

    private static final String SELECT_CONSULTATIONS = "SELECT CONSULTATIONS.*, DOCTORS.doctor_name , PATIENTS.patient_name FROM CONSULTATIONS INNER JOIN DOCTORS ON CONSULTATIONS.doctor_id = DOCTORS.doctor_id INNER JOIN PATIENTS ON CONSULTATIONS.patient_id = PATIENTS.patient_id";
    private static final String SELECT_PENDING_CONSULTATION_REQUESTS = "SELECT CONSULTATIONS.*, DOCTORS.doctor_name , PATIENTS.patient_name FROM CONSULTATIONS INNER JOIN DOCTORS ON CONSULTATIONS.doctor_id = DOCTORS.doctor_id INNER JOIN PATIENTS ON CONSULTATIONS.patient_id = PATIENTS.patient_id WHERE CONSULTATIONS.doctor_id = ? AND LOWER(CONSULTATIONS.consultation_status) = 'pending'";
    private static final String SELECT_ONE_CONSULTATION = "SELECT CONSULTATIONS.*, DOCTORS.doctor_name , PATIENTS.patient_name FROM CONSULTATIONS INNER JOIN DOCTORS ON CONSULTATIONS.doctor_id = DOCTORS.doctor_id INNER JOIN PATIENTS ON CONSULTATIONS.patient_id = PATIENTS.patient_id WHERE consultation_id=?";

    private static final String UPDATE_CONSULTATION = "UPDATE CONSULTATIONS SET consultation_status = ?, consultation_diagnosis = ?, consultation_time = datetime('now', 'localtime') WHERE consultation_id = ?";
    private static final String INSERT_CONSULTATION = "INSERT INTO CONSULTATIONS (doctor_id, patient_id, consultation_requestTime, consultation_status) VALUES (?, ?,datetime('now', 'localtime'), 'Pending')";
    private static final String UPDATE_Rate = "UPDATE CONSULTATIONS SET consultation_rate = ? WHERE consultation_id = ?";

    //patient
    public ConsultationsDTO selectCon(int conId) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(SELECT_ONE_CONSULTATION);

        st.setInt(1, conId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new ConsultationsDTO(rs);
        }
        else {
            return null;
        }

    }

    //patient
    public void insertCon(Consultations c) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(INSERT_CONSULTATION);
        st.setInt(1, c.getDoctor_id());
        st.setInt(2, c.getPatient_id());

        st.executeUpdate();
        conn.close();
    }

    //doctor
    public void updateCon(Consultations c) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(UPDATE_CONSULTATION);
        st.setString(1, c.getConsultation_status());
        st.setString(2, c.getConsultation_diagnosis());
        st.setInt(3, c.getConsultation_id());


        st.executeUpdate();
        conn.close();
    }

    //patient
    public void updateRate(Consultations c) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(UPDATE_Rate);
        st.setInt(1, c.getConsultation_rate());
        st.setInt(2, c.getConsultation_id());


        st.executeUpdate();
        conn.close();
    }

    //doctor
    public ArrayList<ConsultationsDTO> selectAllCon(ConsultationFilterDto filter) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st;
        if(filter.getDoctor_id() != null){
            st = conn.prepareStatement(SELECT_PENDING_CONSULTATION_REQUESTS);
            st.setString(1, filter.getDoctor_id());
        }
        else {
            st = conn.prepareStatement(SELECT_CONSULTATIONS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<ConsultationsDTO> consultations = new ArrayList<>();
        while (rs.next()) {
            consultations.add(new ConsultationsDTO(rs));
        }
        rs.close();
        return consultations;
    }

}
