package com.jdbcconnectivity.Employee_Payroll_System.controller;
import java.util.*;

import com.jdbcconnectivity.Employee_Payroll_System.Services.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;

public class AttendanceController {
    private AttendanceService service = new AttendanceService();

    public boolean markAttendance(Attendance a) { return service.markAttendance(a); }
    public List<Attendance> getAttendanceByEmployee(int empId) { return service.getAttendanceByEmployee(empId); }
    public boolean updateCheckOut(int attendanceId, String checkout) { return service.updateCheckOut(attendanceId, checkout); }
}
