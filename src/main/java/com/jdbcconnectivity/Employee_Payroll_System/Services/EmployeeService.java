package com.jdbcconnectivity.Employee_Payroll_System.Services;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;
import com.jdbcconnectivity.Employee_Payroll_System.DAO.*;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO dao = new EmployeeDAO();
    public boolean addEmployee(Employee e) { return dao.addEmployee(e); }
    public Employee getEmployeeById(int id) { return dao.getEmployeeById(id); }
    public List<Employee> getAllEmployees() { return dao.getAllEmployees(); }
    public boolean updateEmployee(Employee e) { return dao.updateEmployee(e); }
    public boolean deleteEmployee(int id) { return dao.deleteEmployee(id); }
}