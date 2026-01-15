package com.jdbcconnectivity.Employee_Payroll_System.DAO;

import com.jdbcconnectivity.Employee_Payroll_System.model.Payroll;
import com.jdbcconnectivity.Employee_Payroll_System.Util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAO {

    public boolean addPayroll(Payroll p) {
        String query = "INSERT INTO payroll (payroll_id, emp_id, basic_salary, total_bonus, total_deduction, net_salary, payroll_month, generated_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, p.getPayrollId());
            ps.setInt(2, p.getEmpId());
            ps.setDouble(3, p.getBasicSalary());
            ps.setDouble(4, p.getTotalBonus());
            ps.setDouble(5, p.getTotalDeduction());
            ps.setDouble(6, p.getNetSalary());
            ps.setString(7, p.getPayrollMonth());
            ps.setTimestamp(8, p.getGeneratedDate());
            ps.setString(9, p.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public List<Payroll> getPayrollByEmployee(int empId) {
        List<Payroll> list = new ArrayList<>();
        String query = "SELECT * FROM payroll WHERE emp_id = ?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Payroll(
                        rs.getInt("payroll_id"),
                        rs.getInt("emp_id"),
                        rs.getDouble("basic_salary"),
                        rs.getDouble("total_bonus"),
                        rs.getDouble("total_deduction"),
                        rs.getDouble("net_salary"),
                        rs.getString("payroll_month"),
                        rs.getTimestamp("generated_date"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}