package com.jdbcconnectivity.studentsmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // MYSQL Connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "deepanshu@12345"
            );

            // ID is auto-increment, so not included
            String sql = "INSERT INTO student (name, mobile, address) VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(sql);

            String choice;

            do {
                System.out.println("\n--- Enter Student Details ---");

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Mobile: ");
                String mobile = sc.nextLine();

                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                // Bind parameters
                pstmt.setString(1, name);
                pstmt.setString(2, mobile);
                pstmt.setString(3, address);

                pstmt.executeUpdate();
                System.out.println("Student inserted successfully! (ID auto-generated)");

                System.out.print("\nDo you want to insert another student? (yes/no): ");
                choice = sc.nextLine().trim().toLowerCase();

            } while (choice.equals("yes") || choice.equals("y"));

            System.out.println("\nAll student data inserted! Program ended.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
