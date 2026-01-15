package com.jdbcconnectivity.Employee_Payroll_System.model;

public class Salary {
    private int salaryId;
    private int empId;
    private double basicSalary;
    private double hra;
    private double da;
    private double pf;
    private double tax;
    private double grossSalary;
    private double netSalary;
    private String salaryMonth;

    public Salary() {}

    public Salary(int salaryId, int empId, double basicSalary, double hra, double da,
                  double pf, double tax, double grossSalary, double netSalary, String salaryMonth) {
        this.salaryId = salaryId; this.empId = empId; this.basicSalary = basicSalary; this.hra = hra;
        this.da = da; this.pf = pf; this.tax = tax; this.grossSalary = grossSalary;
        this.netSalary = netSalary; this.salaryMonth = salaryMonth;
    }

    // getters & setters (generate in IDE)
    public int getSalaryId() { return salaryId; }
    public void setSalaryId(int salaryId) { this.salaryId = salaryId; }
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    public double getHra() { return hra; }
    public void setHra(double hra) { this.hra = hra; }
    public double getDa() { return da; }
    public void setDa(double da) { this.da = da; }
    public double getPf() { return pf; }
    public void setPf(double pf) { this.pf = pf; }
    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }
    public double getGrossSalary() { return grossSalary; }
    public void setGrossSalary(double grossSalary) { this.grossSalary = grossSalary; }
    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
    public String getSalaryMonth() { return salaryMonth; }
    public void setSalaryMonth(String salaryMonth) { this.salaryMonth = salaryMonth; }

    @Override
    public String toString() {
        return salaryId + " | emp:" + empId + " | net:" + netSalary + " | " + salaryMonth;
    }
}