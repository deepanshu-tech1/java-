package com.jdbcconnectivity.Employee_Payroll_System.Services;
import com.jdbcconnectivity.Employee_Payroll_System.DAO.*;

import com.jdbcconnectivity.Employee_Payroll_System.model.*;
import java.util.*;


public class ReportService {
    private ReportDAO dao = new ReportDAO();
    public boolean addReport(Report r) { return dao.addReport(r); }
    public List<Report> getAllReports() { return dao.getAllReports(); }
}