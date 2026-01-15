package com.jdbcconnectivity.Employee_Payroll_System.model;

import java.sql.Date;
import java.sql.Time;

public class Attendance {
    private int attendanceId;
    private int empId;
    private Date date;
    private Time checkInTime;
    private Time checkOutTime;
    private String status;
    private double workingHours;

    public Attendance() {}

    public Attendance(int attendanceId, int empId, Date date, Time checkInTime, Time checkOutTime, String status, double workingHours) {
        this.attendanceId = attendanceId; this.empId = empId; this.date = date;
        this.checkInTime = checkInTime; this.checkOutTime = checkOutTime;
        this.status = status; this.workingHours = workingHours;
    }

    // getters & setters
    public int getAttendanceId() { return attendanceId; }
    public void setAttendanceId(int attendanceId) { this.attendanceId = attendanceId; }
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public java.sql.Time getCheckInTime() { return checkInTime; }
    public void setCheckInTime(java.sql.Time checkInTime) { this.checkInTime = checkInTime; }
    public java.sql.Time getCheckOutTime() { return checkOutTime; }
    public void setCheckOutTime(java.sql.Time checkOutTime) { this.checkOutTime = checkOutTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getWorkingHours() { return workingHours; }
    public void setWorkingHours(double workingHours) { this.workingHours = workingHours; }

    @Override
    public String toString() {
        return attendanceId + " | emp:" + empId + " | " + date + " | " + status;
    }
}