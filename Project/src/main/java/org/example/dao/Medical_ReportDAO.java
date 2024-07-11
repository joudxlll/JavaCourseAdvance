package org.example.dao;

import org.example.controller.DatabaseConfig;
import org.example.models.Medical_Reports;

import java.sql.*;
import java.util.ArrayList;

public class Medical_ReportDAO {


    private static final String SELECT_MR = "SELECT * FROM MEDICAL_REPORTS WHERE patient_id = ?";
    private static final String INSERT_MR = "INSERT INTO MEDICAL_REPORTS (patient_id, MR_details, MR_reportDate)" +
            " SELECT P.patient_id," +
            " COALESCE((SELECT GROUP_CONCAT('Consultation ID: ' || C.consultation_id || ', Consultation Time: ' || C.consultation_time || ', Diagnosis: ' || C.consultation_diagnosis) FROM CONSULTATIONS C WHERE C.patient_id = P.patient_id ORDER BY C.consultation_time DESC), 'No consultations found') AS MR_details," +
            " datetime('now', 'localtime') AS MR_reportDate " +
            "FROM PATIENTS P WHERE P.patient_id = ?";

    private static final String UPDATE_MR = "UPDATE MEDICAL_REPORTS SET MR_details = COALESCE((SELECT GROUP_CONCAT('Consultation ID: ' || C.consultation_id || ', Consultation Time: ' || C.consultation_time || ', Diagnosis: ' || COALESCE(C.consultation_diagnosis, 'No diagnosis'),' ') FROM CONSULTATIONS C WHERE C.patient_id = MEDICAL_REPORTS.patient_id ORDER BY C.consultation_time DESC), 'No consultations found') WHERE patient_id = ?";

    public ArrayList<Medical_Reports> selectAllMR(int patientId) throws ClassNotFoundException, SQLException {
        Connection conn = DatabaseConfig.getConnection();
        ArrayList<Medical_Reports> MR = new ArrayList<>();
        PreparedStatement select = null;
        PreparedStatement update = null;
        PreparedStatement insert = null;
        ResultSet rs = null;

        try {
            select = conn.prepareStatement(SELECT_MR);
            select.setInt(1, patientId);
            rs = select.executeQuery();

            if (!rs.next()) {
                insert = conn.prepareStatement(INSERT_MR);
                insert.setInt(1, patientId);
                insert.executeUpdate();
            }

            update = conn.prepareStatement(UPDATE_MR);
            update.setInt(1, patientId);
            update.executeUpdate();

            select.setInt(1, patientId);
            rs = select.executeQuery();

            while (rs.next()) {
                MR.add(new Medical_Reports(rs));
            }
        } finally {
            if (rs != null) rs.close();
            if (select != null) select.close();
            if (insert != null) insert.close();
            if (update != null) update.close();
            if (conn != null) conn.close();
        }

        return MR;
    }
}
