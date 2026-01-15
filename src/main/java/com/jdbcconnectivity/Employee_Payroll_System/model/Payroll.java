package com.jdbcconnectivity.Employee_Payroll_System.model;

import java.sql.Timestamp;

public class Payroll {
    private int payrollId;
    private int empId;
    private double basicSalary;
    private double totalBonus;
    private double totalDeduction;
    private double netSalary;
    private String payrollMonth;
    private Timestamp generatedDate;
    private String status;

    public Payroll() {}

    public Payroll(int payrollId, int empId, double basicSalary, double totalBonus, double totalDeduction,
                   double netSalary, String payrollMonth, Timestamp generatedDate, String status) {
        this.payrollId = payrollId; this.empId = empId; this.basicSalary = basicSalary;
        this.totalBonus = totalBonus; this.totalDeduction = totalDeduction; this.netSalary = netSalary;
        this.payrollMonth = payrollMonth; this.generatedDate = generatedDate; this.status = status;
    }

    // getters/setters...
    public int getPayrollId() { return payrollId; }
    public void setPayrollId(int payrollId) { this.payrollId = payrollId; }
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    public double getTotalBonus() { return totalBonus; }
    public void setTotalBonus(double totalBonus) { this.totalBonus = totalBonus; }
    public double getTotalDeduction() { return totalDeduction; }
    public void setTotalDeduction(double totalDeduction) { this.totalDeduction = totalDeduction; }
    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
    public String getPayrollMonth() { return payrollMonth; }
    public void setPayrollMonth(String payrollMonth) { this.payrollMonth = payrollMonth; }
    public Timestamp getGeneratedDate() { return generatedDate; }
    public void setGeneratedDate(Timestamp generatedDate) { this.generatedDate = generatedDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return payrollId + " | emp:" + empId + " | net:" + netSalary + " | " + payrollMonth;
    }
}