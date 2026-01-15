package com.jdbcconnectivity.Employee_Payroll_System.DAO;

import com.jdbcconnectivity.Employee_Payroll_System.model.Attendance;
import com.jdbcconnectivity.Employee_Payroll_System.Util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public boolean markAttendance(Attendance at) {
        String query = "INSERT INTO attendance (attendance_id, emp_id, date, check_in_time, check_out_time, status, working_hours) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, at.getAttendanceId());
            ps.setInt(2, at.getEmpId());
            ps.setDate(3, at.getDate());
            ps.setTime(4, at.getCheckInTime());
            ps.setTime(5, at.getCheckOutTime());
            ps.setString(6, at.getStatus());
            ps.setDouble(7, at.getWorkingHours());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public List<Attendance> getAttendanceByEmployee(int empId) {
        List<Attendance> list = new ArrayList<>();
        String query = "SELECT * FROM attendance WHERE emp_id = ?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attendance(
                        rs.getInt("attendance_id"),
                        rs.getInt("emp_id"),
                        rs.getDate("date"),
                        rs.getTime("check_in_time"),
                        rs.getTime("check_out_time"),
                        rs.getString("status"),
                        rs.getDouble("working_hours")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean updateCheckOut(int attendanceId, String checkout) {
        String query = "UPDATE attendance SET check_out_time = ? WHERE attendance_id = ?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, checkout);
            ps.setInt(2, attendanceId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}