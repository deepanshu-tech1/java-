package com.jdbcconnectivity.Employee_Payroll_System.DAO;

import com.jdbcconnectivity.Employee_Payroll_System.model.*;
import com.jdbcconnectivity.Employee_Payroll_System.Util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public boolean addReport(Report r) {
        String query = "INSERT INTO reports (report_type, month, year, generated_by, file_path) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, r.getReportType());
            ps.setString(2, r.getMonth());
            ps.setInt(3, r.getYear());
            ps.setString(4, r.getGeneratedBy());
            ps.setString(5, r.getFilePath());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public List<Report> getAllReports() {
        List<Report> list = new ArrayList<>();
        String query = "SELECT * FROM reports";
        try (Connection con = DataBaseUtil.establishConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Report(
                        rs.getInt("report_id"),
                        rs.getString("report_type"),
                        rs.getString("month"),
                        rs.getInt("year"),
                        rs.getString("generated_by"),
                        rs.getTimestamp("generated_date"),
                        rs.getString("file_path")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}