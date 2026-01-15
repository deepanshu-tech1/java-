package com.jdbcconnectivity.Employee_Payroll_System.model;

import java.sql.Timestamp;

public class Report {
    private int reportId;
    private String reportType;
    private String month;
    private int year;
    private String generatedBy;
    private Timestamp generatedDate;
    private String filePath;

    public Report() {}

    public Report(int reportId, String reportType, String month, int year, String generatedBy, Timestamp generatedDate, String filePath) {
        this.reportId = reportId; this.reportType = reportType; this.month = month; this.year = year;
        this.generatedBy = generatedBy; this.generatedDate = generatedDate; this.filePath = filePath;
    }

    // getters/setters...
    public int getReportId() { return reportId; }
    public void setReportId(int reportId) { this.reportId = reportId; }
    public String getReportType() { return reportType; }
    public void setReportType(String reportType) { this.reportType = reportType; }
    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getGeneratedBy() { return generatedBy; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
    public Timestamp getGeneratedDate() { return generatedDate; }
    public void setGeneratedDate(Timestamp generatedDate) { this.generatedDate = generatedDate; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    @Override
    public String toString() {
        return reportId + " | " + reportType + " | " + month + "-" + year;
    }
}