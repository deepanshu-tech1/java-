package com.jdbcconnectivity.Employee_Payroll_System.DAO;

import com.jdbcconnectivity.Employee_Payroll_System.model.*;
import com.jdbcconnectivity.Employee_Payroll_System.Util.*;

import java.sql.*;

public class UserDAO {

    // ---------------- REGISTER USER -------------------
    public boolean addUser(User user) {
        // user_id auto increment ke liye remove kiya
        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, user.getUsername().trim());
            ps.setString(2, user.getPassword().trim());
            ps.setString(3, user.getRole().trim());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    // ---------------- LOGIN USER -------------------
    public User login(String username, String password) {

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection con = DataBaseUtil.establishConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username.trim());
            ps.setString(2, password.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // login fail
    }
}
