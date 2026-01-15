package com.jdbcconnectivity.Employee_Payroll_System.Services;
import com.jdbcconnectivity.Employee_Payroll_System.DAO.*;
import java.util.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;

public class PayrollService {
    private PayrollDAO dao = new PayrollDAO();
    public boolean addPayroll(Payroll p) { return dao.addPayroll(p); }
    public List<Payroll> getPayrollByEmployee(int empId) { return dao.getPayrollByEmployee(empId); }
	public Payroll getPayrollById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}