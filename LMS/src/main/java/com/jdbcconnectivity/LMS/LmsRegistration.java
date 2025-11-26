package com.jdbcconnectivity.LMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class LmsRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Connection details
        String url = "jdbc:mysql://localhost:3306/LMS";
        String user = "root";       // change if needed
        String pass = "deepanshu@12345";       // change if needed

        String insertQuery =
                "INSERT INTO course(course_id, course_name, descript, duration_in_hours, min_enrollment, max_enrollment) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(insertQuery)) {

            System.out.println("======= COURSE REGISTRATION =======");

            System.out.print("Enter Course ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Course Name: ");
            String courseName = sc.nextLine();

            System.out.print("Enter Description: ");
            String desc = sc.nextLine();

            System.out.print("Enter Duration in Hours: ");
            int duration = sc.nextInt();

            System.out.print("Enter Minimum Enrollment: ");
            int min = sc.nextInt();

            System.out.print("Enter Maximum Enrollment: ");
            int max = sc.nextInt();

            // Setting values in query
            ps.setString(1, id);
            ps.setString(2, courseName);
            ps.setString(3, desc);
            ps.setInt(4, duration);
            ps.setInt(5, min);
            ps.setInt(6, max);
            sc.close();

            int rows = ps.executeUpdate();
            System.out.println("\n" + rows + " Course Inserted Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
