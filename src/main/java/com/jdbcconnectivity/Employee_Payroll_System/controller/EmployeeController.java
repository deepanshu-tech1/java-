package com.jdbcconnectivity.Employee_Payroll_System.controller;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;
import com.jdbcconnectivity.Employee_Payroll_System.Services.*;
import java.util.*;


public class EmployeeController {

    private EmployeeService empService = new EmployeeService();

    public boolean addEmployee(Employee e) {
        return empService.addEmployee(e);
    }

    public Employee getEmployeeById(int empId) {
        return empService.getEmployeeById(empId);
    }

    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }

    public boolean deleteEmployee(int empId) {
        return empService.deleteEmployee(empId);
    }

	public boolean updateEmployee(Employee existing) {
		// TODO Auto-generated method stub
		return false;
	}
}
