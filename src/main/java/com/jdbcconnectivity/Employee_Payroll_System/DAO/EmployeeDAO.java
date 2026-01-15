package com.jdbcconnectivity.Employee_Payroll_System.DAO;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;


import com.jdbcconnectivity.Employee_Payroll_System.Util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {

    public boolean addEmployee(Employee emp) {
        String q = "INSERT INTO employee (emp_id, emp_name, contact, gender, dob, address, department, designation, date_of_joining) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(q)) {

            ps.setInt(1, emp.getEmpId());
            ps.setString(2, emp.getEmpName());
            ps.setString(3, emp.getContact());
            ps.setString(4, emp.getGender());
            ps.setDate(5, emp.getDob());
            ps.setString(6, emp.getAddress());
            ps.setString(7, emp.getDepartment());
            ps.setString(8, emp.getDesignation());
            ps.setDate(9, emp.getDateOfJoining());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Employee getEmployeeById(int id) {
        String q = "SELECT * FROM employee WHERE emp_id = ?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(q)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("contact"),
                        rs.getString("gender"),
                        rs.getDate("dob"),
                        rs.getString("address"),
                        rs.getString("department"),
                        rs.getString("designation"),
                        rs.getDate("date_of_joining")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String q = "SELECT * FROM employee";
        try (Connection con = DataBaseUtil.establishConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(q)) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("emp_name"),
                        rs.getString("contact"),
                        rs.getString("gender"),
                        rs.getDate("dob"),
                        rs.getString("address"),
                        rs.getString("department"),
                        rs.getString("designation"),
                        rs.getDate("date_of_joining")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean updateEmployee(Employee emp) {
        String q = "UPDATE employee SET emp_name=?, contact=?, gender=?, dob=?, address=?, department=?, designation=?, date_of_joining=? WHERE emp_id=?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(q)) {
            ps.setString(1, emp.getEmpName());
            ps.setString(2, emp.getContact());
            ps.setString(3, emp.getGender());
            ps.setDate(4, emp.getDob());
            ps.setString(5, emp.getAddress());
            ps.setString(6, emp.getDepartment());
            ps.setString(7, emp.getDesignation());
            ps.setDate(8, emp.getDateOfJoining());
            ps.setInt(9, emp.getEmpId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public boolean deleteEmployee(int id) {
        String q = "DELETE FROM employee WHERE emp_id = ?";
        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(q)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}