package org.example.dao;

import org.example.controller.DatabaseConfig;
import org.example.models.Doctors;
import org.example.models.Patients;

import java.sql.*;

public class AuthDAO {

    private static final String SELECT_DOCTORS_SIGHIN = "SELECT * FROM DOCTORS WHERE doctor_email = ? AND doctor_password = ?";
    private static final String SELECT_PATIENTS_SIGHIN = "SELECT * FROM PATIENTS WHERE patient_email = ? AND patient_password = ?";

    public Object Auth(String user, String email, String password) throws SQLException, ClassNotFoundException {
        Connection conn = DatabaseConfig.getConnection();
        String selectQuery;
        if (user.equalsIgnoreCase("DOCTORS")) {
            selectQuery = SELECT_DOCTORS_SIGHIN;
        } else if (user.equalsIgnoreCase("PATIENTS")) {
            selectQuery = SELECT_PATIENTS_SIGHIN;
        } else {
            throw new IllegalArgumentException("Invalid user type");
        }

        try (PreparedStatement st = conn.prepareStatement(selectQuery)) {

            st.setString(1, email);
            st.setString(2, password);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    if (user.equalsIgnoreCase("DOCTORS")) {
                        return new Doctors(rs);
                    } else if (user.equalsIgnoreCase("PATIENTS")) {
                        return new Patients(rs);
                    }
                }
            }
        }
        return null;
    }
}
