package com.jdbcconnectivity.Employee_Payroll_System.controller;

import com.jdbcconnectivity.Employee_Payroll_System.Services.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;


import java.util.List;

public class SalaryController {
    private SalaryService service = new SalaryService();

    public boolean addSalary(Salary s) { return service.addSalary(s); }
    public Salary getSalaryById(int id) { return service.getSalaryById(id); }
    public List<Salary> getSalaryByEmployee(int empId) { return service.getSalaryByEmployee(empId); }
}
