package com.jdbcconnectivity.Employee_Payroll_System.model;

import java.sql.Date;

public class BonusDeduction {
    private int bdId;
    private int empId;
    private String type;
    private double amount;
    private String reason;
    private Date dateApplied;
    private String addedBy;

    public BonusDeduction() {}

    public BonusDeduction(int bdId, int empId, String type, double amount, String reason, Date dateApplied, String addedBy) {
        this.bdId = bdId; this.empId = empId; this.type = type; this.amount = amount;
        this.reason = reason; this.dateApplied = dateApplied; this.addedBy = addedBy;
    }

    // getters/setters
    public int getBdId() { return bdId; }
    public void setBdId(int bdId) { this.bdId = bdId; }
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public java.sql.Date getDateApplied() { return dateApplied; }
    public void setDateApplied(java.sql.Date dateApplied) { this.dateApplied = dateApplied; }
    public String getAddedBy() { return addedBy; }
    public void setAddedBy(String addedBy) { this.addedBy = addedBy; }

    @Override
    public String toString() {
        return bdId + " | emp:" + empId + " | " + type + " | " + amount + " | " + dateApplied;
    }
}
