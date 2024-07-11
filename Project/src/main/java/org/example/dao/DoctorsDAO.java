package org.example.dao;

import org.example.controller.DatabaseConfig;
import org.example.dto.DoctorFilterDTO;
import org.example.dto.DoctorConsultationScheduleDTO;
import org.example.models.Doctors;

import java.sql.*;
import java.util.ArrayList;

public class DoctorsDAO {


    private static final String INSERT_DOCTOR = "INSERT INTO DOCTORS (doctor_name, doctor_specialty, doctor_email, doctor_password, doctor_phone) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_DOCTORS = "SELECT * FROM DOCTORS";


    public void insertDoc(Doctors d) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();
        PreparedStatement st = conn.prepareStatement(INSERT_DOCTOR);
        st.setString(1, d.getDoctor_name());
        st.setString(2, d.getDoctor_specialty());
        st.setString(3, d.getDoctor_email());
        st.setString(4, d.getDoctor_password());
        st.setInt(5, d.getDoctor_phone());

        st.executeUpdate();
        conn.close();
    }


    public ArrayList<Doctors> selectAllDoc() throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();
        PreparedStatement st= conn.prepareStatement(SELECT_DOCTORS);

        ResultSet rs = st.executeQuery();
        ArrayList<Doctors> doctors = new ArrayList<>();
        while (rs.next()) {
            doctors.add(new Doctors(rs));
        }
        rs.close();
        return doctors;
    }



    public ArrayList<DoctorConsultationScheduleDTO> SearchDoctors(DoctorFilterDTO filter) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();
//        String SEARCH_QUERY = "SELECT DISTINCT d.* FROM doctors d INNER JOIN schedules s ON d.doctor_id = s.doctor_id WHERE 1=1"; //And
        String SEARCH_QUERY = "SELECT d.doctor_id, d.doctor_name, d.doctor_specialty, s.isAvailable, ROUND(AVG(c.consultation_rate)) AS consultation_rate FROM doctors d INNER JOIN schedules s ON d.doctor_id = s.doctor_id INNER JOIN consultations c ON d.doctor_id = c.doctor_id WHERE 1=1"; //And

        ArrayList<DoctorConsultationScheduleDTO> doctors = new ArrayList<>();

        try (PreparedStatement st = prepareStatement(conn, SEARCH_QUERY, filter)) {

            int paramIndex = 1;

            if (filter.getDoctor_specialty() != null) {
                st.setString(paramIndex++, filter.getDoctor_specialty());
            }

            if (filter.getConsultation_rate() != null) {
                st.setInt(paramIndex++, filter.getConsultation_rate());
            }

            if (filter.getDoctor_name() != null) {
                st.setString(paramIndex++, filter.getDoctor_name());
            }

            if (filter.getDoctor_id() != null) {
                st.setInt(paramIndex++, filter.getDoctor_id());
            }

            if (filter.getAvailable() != null) {
                if(!filter.getAvailable() || filter.getAvailable()){
                    st.setBoolean(paramIndex++, filter.getAvailable());
                }
            }

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    doctors.add(new DoctorConsultationScheduleDTO(rs));
                }
            }
        }

        return doctors;
    }

    private PreparedStatement prepareStatement(Connection conn, String baseQuery, DoctorFilterDTO filter) throws SQLException {
        StringBuilder queryBuilder = new StringBuilder(baseQuery);

        if (filter.getDoctor_specialty() != null) {
            queryBuilder.append(" AND d.doctor_specialty COLLATE NOCASE = ?");
        }

        if (filter.getConsultation_rate() != null) {
            queryBuilder.append(" And consultation_rate = ?");
        }

        if (filter.getDoctor_name() != null) {
            queryBuilder.append(" AND d.doctor_name COLLATE NOCASE = ?");
        }

        if (filter.getDoctor_id() != null) {
            queryBuilder.append(" AND d.doctor_id = ?");
        }

        if (filter.getAvailable() != null) {
            if(!filter.getAvailable() || filter.getAvailable()){
                queryBuilder.append(" AND s.isAvailable = ?");
            }
        }
        queryBuilder.append(" GROUP BY d.doctor_id, d.doctor_name, d.doctor_specialty, s.isAvailable;");
        PreparedStatement st = conn.prepareStatement(queryBuilder.toString());

        return st;
    }





//    public ArrayList<Doctors> SearchDoctors(DoctorFilterDTO filter) throws SQLException, ClassNotFoundException {
        //Connection conn = DatabaseConfig.getConnection();

//        String SEARCH_QUERY = "SELECT DISTINCT d.* FROM doctors d INNER JOIN schedules s ON d.doctor_id = s.doctor_id ";
//        PreparedStatement st;
//
//
//        if (filter.getDoctor_specialty() != null) {
//            SEARCH_QUERY += "AND d.doctor_specialty = ? ";
//        }
//
//        if (filter.getConsultation_rate() != null) {
//            SEARCH_QUERY += " AND EXISTS (SELECT 1 FROM consultations c WHERE d.doctor_id = c.doctor_id AND c.consultation_rate >= ?) ";
//        }
//
//        if (filter.getDoctor_name() != null) {
//            SEARCH_QUERY += " AND d.doctor_name = ? ";
//        }
//
//        if (filter.getDoctor_id() != null) {
//            SEARCH_QUERY += " AND d.doctor_id = ? ";
//        }
//
//        if (filter.getAvailable() != null && filter.getAvailable()) {
//            SEARCH_QUERY += " AND s.isAvailable = ? ";
//        }
//
//        st = conn.prepareStatement(SEARCH_QUERY);
//
//        int paramIndex = 1;
//        if (filter.getDoctor_specialty() != null) {
//            st.setString(paramIndex++, filter.getDoctor_specialty());
//        }
//
//        if (filter.getConsultation_rate() != null) {
//            st.setInt(paramIndex++, filter.getConsultation_rate());
//        }
//
//        if (filter.getDoctor_name() != null) {
//            st.setString(paramIndex++, filter.getDoctor_name());
//        }
//
//        if (filter.getDoctor_id() != null) {
//            st.setInt(paramIndex++, filter.getDoctor_id());
//        }
//
//        if (filter.getAvailable() != null) {
//            st.setBoolean(paramIndex++, filter.getAvailable());
//        }
//
//        ResultSet rs = st.executeQuery();
//        ArrayList<Doctors> doctors = new ArrayList<>();
//        while (rs.next()) {
//            doctors.add(new Doctors(rs));
//        }
//
//        rs.close();
//        st.close();
//        conn.close();
//
//        return doctors;
//    }



}
