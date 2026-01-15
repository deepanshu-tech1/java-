package com.jdbcconnectivity.Employee_Payroll_System.controller;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;
import com.jdbcconnectivity.Employee_Payroll_System.Services.*;

import java.util.List;

public class PayrollController {
    private PayrollService service = new PayrollService();

    public boolean addPayroll(Payroll p) { return service.addPayroll(p); }
    public List<Payroll> getPayrollByEmployee(int empId) { return service.getPayrollByEmployee(empId); }
    public Payroll getPayrollById(int id) { return service.getPayrollById(id); }
}
