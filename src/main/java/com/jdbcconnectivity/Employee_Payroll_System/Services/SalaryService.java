package com.jdbcconnectivity.Employee_Payroll_System.Services;

import com.jdbcconnectivity.Employee_Payroll_System.DAO.SalaryDAO;
import com.jdbcconnectivity.Employee_Payroll_System.model.Salary;
import java.util.List;

public class SalaryService {
    private SalaryDAO dao = new SalaryDAO();
    public boolean addSalary(Salary s) { return dao.addSalary(s); }
    public Salary getSalaryById(int id) { return dao.getSalaryById(id); }
    public List<Salary> getSalaryByEmployee(int empId) { return dao.getSalaryByEmployee(empId); }
}