package com.jdbcconnectivity.Employee_Payroll_System.controller;
import com.jdbcconnectivity.Employee_Payroll_System.Util.SalaryPdfUtil;

import com.jdbcconnectivity.Employee_Payroll_System.Services.SalaryService;
import com.jdbcconnectivity.Employee_Payroll_System.model.Salary;

import java.util.List;

public class SalaryController {

    // ✅ YOUR CODE
    private SalaryService service = new SalaryService();
    public boolean addSalary(Salary s) { return service.addSalary(s); }
    public Salary getSalaryById(int id) { return service.getSalaryById(id); }
    public List<Salary> getSalaryByEmployee(int empId) { return service.getSalaryByEmployee(empId); }

    // ✅ MY CODE (Excel Print)
    public void printSalarySlipExcel(int salaryId) {
        service.exportSalarySlipToExcel(salaryId);
    }
    public void printSalarySlipPdf(int salaryId) {
        service.exportSalarySlipToPdf(salaryId);
    }
    public void generateSalarySlipPdf(int salaryId) {
        Salary s = service.getSalaryById(salaryId);
        if (s != null) {
            SalaryPdfUtil.generateSalarySlipPdf(s);
        } else {
            System.out.println("❌ Salary not found");
        }
    }

}
