package com.jdbcconnectivity.Employee_Payroll_System.controller;
import com.jdbcconnectivity.Employee_Payroll_System.Services.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;

import java.util.List;

public class ReportController {
    private ReportService service = new ReportService();

    public boolean addReport(Report r) { return service.addReport(r); }
    public List<Report> getAllReports() { return service.getAllReports(); }
}
