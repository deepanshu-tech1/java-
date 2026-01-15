package com.jdbcconnectivity.Employee_Payroll_System.Services;

import java.util.List;

import com.jdbcconnectivity.Employee_Payroll_System.DAO.AttendanceDAO;
import com.jdbcconnectivity.Employee_Payroll_System.model.Attendance;

public class AttendanceService {
    private AttendanceDAO dao = new AttendanceDAO();
    public boolean markAttendance(Attendance a) { return dao.markAttendance(a); }
    public List<Attendance> getAttendanceByEmployee(int empId) { return dao.getAttendanceByEmployee(empId); }
    public boolean updateCheckOut(int attendanceId, String checkout) { return dao.updateCheckOut(attendanceId, checkout); }
}