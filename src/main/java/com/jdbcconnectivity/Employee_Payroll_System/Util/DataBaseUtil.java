package com.jdbcconnectivity.Employee_Payroll_System.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {

    // Database credentials
    private static final String url = "jdbc:mysql://localhost:3306/Employee_Payroll_System";
    private static final String username = "root";
    private static final String password = "deepanshu@12345";

    // Method to establish connection
    public static Connection establishConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        }
    }

    // Method to create tables
    public static void createTables() {
        try (Connection con = establishConnection()) {

            if (con != null) {

                try (Statement stmt = con.createStatement()) {

                    // Employee table
                    String createEmployeeTable =
                            "CREATE TABLE IF NOT EXISTS employee ("
                                    + "emp_id INT PRIMARY KEY NOT NULL, "
                                    + "emp_name VARCHAR(100) NOT NULL, "
                                    + "contact VARCHAR(10) NOT NULL, "
                                    + "gender VARCHAR(10) NOT NULL, "
                                    + "dob DATE NOT NULL, "
                                    + "address VARCHAR(200) NOT NULL, "
                                    + "department VARCHAR(50) NOT NULL, "
                                    + "designation VARCHAR(50) NOT NULL, "
                                    + "date_of_joining DATE NOT NULL"
                                    + ")";
                    // Attendance table
                    String createAttendanceTable =
                            "CREATE TABLE IF NOT EXISTS attendance ("
                                    + "attendance_id INT PRIMARY KEY NOT NULL, "
                                    + "emp_id INT NOT NULL, "
                                    + "date DATE NOT NULL, "
                                    + "check_in_time TIME NULL, "
                                    + "check_out_time TIME NULL, "
                                    + "status VARCHAR(20) NOT NULL DEFAULT 'Present', "
                                    + "working_hours DECIMAL(5,2) NULL, "
                                    + "CONSTRAINT fk_emp FOREIGN KEY (emp_id) REFERENCES employee(emp_id)"
                                    + ")";

                    // Salary table
                    String createSalaryTable =
                            "CREATE TABLE IF NOT EXISTS salary ("
                                    + "salary_id INT PRIMARY KEY NOT NULL, "
                                    + "emp_id INT NOT NULL, "
                                    + "basic_salary DECIMAL(10,2) NOT NULL, "
                                    + "hra DECIMAL(10,2) DEFAULT 0, "
                                    + "da DECIMAL(10,2) DEFAULT 0, "
                                    + "pf DECIMAL(10,2) DEFAULT 0, "
                                    + "tax DECIMAL(10,2) DEFAULT 0, "
                                    + "gross_salary DECIMAL(10,2) NOT NULL, "
                                    + "net_salary DECIMAL(10,2) NOT NULL, "
                                    + "salary_month VARCHAR(20) NOT NULL, "
                                    + "CONSTRAINT fk_salary_emp FOREIGN KEY (emp_id) REFERENCES employee(emp_id)"
                                    + ")";

                    // Bonus / Deduction table (FIXED DEFAULT DATE)
                    String createBonusDeductionTable =
                            "CREATE TABLE IF NOT EXISTS bonus_deduction ("
                                    + "bd_id INT PRIMARY KEY NOT NULL, "
                                    + "emp_id INT NOT NULL, "
                                    + "type VARCHAR(20) NOT NULL, "
                                    + "amount DECIMAL(10,2) NOT NULL, "
                                    + "reason VARCHAR(250) NULL, "
                                    + "date_applied DATE DEFAULT (CURRENT_DATE), "
                                    + "added_by VARCHAR(50) NULL, "
                                    + "CONSTRAINT fk_bd_emp FOREIGN KEY (emp_id) REFERENCES employee(emp_id)"
                                    + ")";

                    // Payroll table
                    String createPayrollTable =
                            "CREATE TABLE IF NOT EXISTS payroll ("
                                    + "payroll_id INT PRIMARY KEY NOT NULL, "
                                    + "emp_id INT NOT NULL, "
                                    + "basic_salary DECIMAL(10,2) NOT NULL, "
                                    + "total_bonus DECIMAL(10,2) DEFAULT 0, "
                                    + "total_deduction DECIMAL(10,2) DEFAULT 0, "
                                    + "net_salary DECIMAL(10,2) NOT NULL, "
                                    + "payroll_month VARCHAR(20) NOT NULL, "
                                    + "generated_date DATETIME DEFAULT CURRENT_TIMESTAMP, "
                                    + "status VARCHAR(20) DEFAULT 'generated', "
                                    + "CONSTRAINT fk_payroll_emp FOREIGN KEY (emp_id) REFERENCES employee(emp_id)"
                                    + ")";

                    // Reports table
                    String createReportsTable =
                            "CREATE TABLE IF NOT EXISTS reports ("
                                    + "report_id INT PRIMARY KEY AUTO_INCREMENT, "
                                    + "report_type VARCHAR(50) NOT NULL, "
                                    + "month VARCHAR(15), "
                                    + "year INT, "
                                    + "generated_by VARCHAR(50), "
                                    + "generated_date DATETIME DEFAULT CURRENT_TIMESTAMP, "
                                    + "file_path VARCHAR(255)"
                                    + ")";
                    
                 // User/Admin table
                    String createUserTable =
                            "CREATE TABLE IF NOT EXISTS users ("
                            + "user_id INT PRIMARY KEY NOT NULL, "
                            + "username VARCHAR(50) UNIQUE NOT NULL, "
                            + "password VARCHAR(100) NOT NULL, "
                            + "role VARCHAR(30) DEFAULT 'admin'"
                            + ")";
                    

                    // Add queries to batch
                    stmt.addBatch(createEmployeeTable);
                    stmt.addBatch(createAttendanceTable);
                    stmt.addBatch(createSalaryTable);
                    stmt.addBatch(createBonusDeductionTable);
                    stmt.addBatch(createPayrollTable);
                    stmt.addBatch(createReportsTable);
                    stmt.addBatch(createUserTable);

                    // Execute batch
                    stmt.executeBatch();
                    

                }
            }

        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
    }
}
