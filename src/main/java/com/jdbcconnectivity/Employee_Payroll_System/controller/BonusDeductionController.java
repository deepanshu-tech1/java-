package com.jdbcconnectivity.Employee_Payroll_System.controller;
import java.util.*;
import com.jdbcconnectivity.Employee_Payroll_System.Services.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;

public class BonusDeductionController {
    private BonusDeductionService service = new BonusDeductionService();

    public boolean addBonusDeduction(BonusDeduction b) { return service.addBonusDeduction(b); }
    public List<BonusDeduction> getAllByEmployee(int empId) { return service.getAllByEmployee(empId); }
}
