package com.jdbcconnectivity.Employee_Payroll_System.DAO;

import com.jdbcconnectivity.Employee_Payroll_System.model.BonusDeduction;
import com.jdbcconnectivity.Employee_Payroll_System.Util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BonusDeductionDAO {

    public boolean addBonusDeduction(BonusDeduction bd) {
        String query = "INSERT INTO bonus_deduction (bd_id, emp_id, type, amount, reason, date_applied, added_by) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bd.getBdId());
            ps.setInt(2, bd.getEmpId());
            ps.setString(3, bd.getType());
            ps.setDouble(4, bd.getAmount());
            ps.setString(5, bd.getReason());
            ps.setDate(6, bd.getDateApplied());
            ps.setString(7, bd.getAddedBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public List<BonusDeduction> getAllByEmployee(int empId) {
        List<BonusDeduction> list = new ArrayList<>();
        String query = "SELECT * FROM bonus_deduction WHERE emp_id = ?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BonusDeduction(
                        rs.getInt("bd_id"),
                        rs.getInt("emp_id"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getString("reason") != null ? rs.getString("reason") : null,
                        rs.getDate("date_applied"),
                        rs.getString("added_by")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}