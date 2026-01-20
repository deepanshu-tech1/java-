package com.jdbcconnectivity.Employee_Payroll_System.model;

import java.sql.Date;

public class Employee {
    private int empId;
    private String empName;
    private String contact;
    private String gender;
    private Date dob;
    private String address;
    private String department;
    private String designation;
    private Date dateOfJoining;

    public Employee() {}

    public Employee(int empId, String empName, String contact, String gender, Date dob,
                    String address, String department, String designation, Date dateOfJoining) {
        this.empId = empId; this.empName = empName; this.contact = contact; this.gender = gender;
        this.dob = dob; this.address = address; this.department = department;
        this.designation = designation; this.dateOfJoining = dateOfJoining;
    }

    // getters & setters
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public Date getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(Date dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    @Override
    public String toString() {
        return empId + " | " + empName + " | " + department + " | " + designation +" |" + address;
    }
}