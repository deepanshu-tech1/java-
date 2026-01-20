package com.jdbcconnectivity.Employee_Payroll_System.DAO;

import com.jdbcconnectivity.Employee_Payroll_System.model.Salary;

import com.jdbcconnectivity.Employee_Payroll_System.Util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAO {

    public boolean addSalary(Salary s) {
        String query = "INSERT INTO salary (salary_id, emp_id, basic_salary, hra, da, pf, tax, gross_salary, net_salary, salary_month) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, s.getSalaryId());
            ps.setInt(2, s.getEmpId());
            ps.setDouble(3, s.getBasicSalary());
            ps.setDouble(4, s.getHra());
            ps.setDouble(5, s.getDa());
            ps.setDouble(6, s.getPf());
            ps.setDouble(7, s.getTax());
            ps.setDouble(8, s.getGrossSalary());
            ps.setDouble(9, s.getNetSalary());
            ps.setString(10, s.getSalaryMonth());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public Salary getSalaryById(int salaryId) {
        String query = "SELECT * FROM salary WHERE salary_id = ?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, salaryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Salary(
                        rs.getInt("salary_id"),
                        rs.getInt("emp_id"),
                        rs.getDouble("basic_salary"),
                        rs.getDouble("hra"),
                        rs.getDouble("da"),
                        rs.getDouble("pf"),
                        rs.getDouble("tax"),
                        rs.getDouble("gross_salary"),
                        rs.getDouble("net_salary"),
                        rs.getString("salary_month")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Salary> getSalaryByEmployee(int empId) {
        List<Salary> list = new ArrayList<>();
        String query = "SELECT * FROM salary WHERE emp_id = ?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Salary(
                        rs.getInt("salary_id"),
                        rs.getInt("emp_id"),
                        rs.getDouble("basic_salary"),
                        rs.getDouble("hra"),
                        rs.getDouble("da"),
                        rs.getDouble("pf"),
                        rs.getDouble("tax"),
                        rs.getDouble("gross_salary"),
                        rs.getDouble("net_salary"),
                        rs.getString("salary_month")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}