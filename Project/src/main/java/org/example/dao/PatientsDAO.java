package org.example.dao;


import org.example.controller.DatabaseConfig;
import org.example.models.Doctors;
import org.example.models.Patients;

import java.sql.*;
import java.util.ArrayList;

public class PatientsDAO {

    private static final String INSERT_DOCTOR = "INSERT INTO PATIENTS (patient_name, patient_email, patient_password, patient_phone, patient_dateOfBirth) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_PATIENTS = "SELECT * FROM PATIENTS";


    public void insertPat(Patients d) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st = conn.prepareStatement(INSERT_DOCTOR);
        st.setString(1, d.getPatient_name());
        st.setString(2, d.getPatient_email());
        st.setString(3, d.getPatient_password());
        st.setInt(4, d.getPatient_phone());
        st.setObject(5, d.getPatient_dateOfBirth());

//        st.setDate(5, Date.valueOf(d.getPatient_dateOfBirth()));
//        System.out.println(d.getPatient_dateOfBirth());
//        System.out.println(Date.valueOf(d.getPatient_dateOfBirth()));


        st.executeUpdate();
        conn.close();
    }

    public ArrayList<Patients> selectAllPat() throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement st= conn.prepareStatement(SELECT_PATIENTS);

        ResultSet rs = st.executeQuery();
        ArrayList<Patients> patients = new ArrayList<>();
        while (rs.next()) {
            patients.add(new Patients(rs));
        }
        rs.close();
        return patients;
    }

}
