package com.jdbcconnectivity.Employee_Payroll_System.Services;
import com.jdbcconnectivity.Employee_Payroll_System.Util.SalaryPdfUtil;

import com.jdbcconnectivity.Employee_Payroll_System.DAO.SalaryDAO;
import com.jdbcconnectivity.Employee_Payroll_System.Util.SalaryExcelUtil;
import com.jdbcconnectivity.Employee_Payroll_System.model.Salary;

import java.util.List;

public class SalaryService {

    // ✅ YOUR CODE
    private SalaryDAO dao = new SalaryDAO();
    public boolean addSalary(Salary s) { return dao.addSalary(s); }
    public Salary getSalaryById(int id) { return dao.getSalaryById(id); }
    public List<Salary> getSalaryByEmployee(int empId) { return dao.getSalaryByEmployee(empId); }

    // ✅ MY CODE (Excel Export)
    public void exportSalarySlipToExcel(int salaryId) {
        Salary salary = dao.getSalaryById(salaryId);
        if (salary != null) {
            SalaryExcelUtil.generateSalarySlip(salary);
        } else {
            System.out.println("❌ Salary not found!");
        }
    }
    public void exportSalarySlipToPdf(int salaryId) {
        Salary salary = dao.getSalaryById(salaryId);
        if (salary != null) {
            SalaryPdfUtil.generateSalarySlipPdf(salary);
        } else {
            System.out.println("❌ Salary not found");
        }
    }
}
