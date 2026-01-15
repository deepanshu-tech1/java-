package com.jdbcconnectivity.Employee_Payroll_System.Services;
import com.jdbcconnectivity.Employee_Payroll_System.DAO.*;
import java.util.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;

public class BonusDeductionService {
    private BonusDeductionDAO dao = new BonusDeductionDAO();
    public boolean addBonusDeduction(BonusDeduction b) { return dao.addBonusDeduction(b); }
    public List<BonusDeduction> getAllByEmployee(int empId) { return dao.getAllByEmployee(empId); }
}
