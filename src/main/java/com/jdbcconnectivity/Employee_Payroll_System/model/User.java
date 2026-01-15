package com.jdbcconnectivity.Employee_Payroll_System.model;
public class User {
    private int userId;
    private String username;
    private String password;
    private String role;

    public User() {}

    public User(int userId, String username, String password, String role) {
        this.userId = userId; this.username = username; this.password = password; this.role = role;
    }
    // getters/setters
    public int getUserId1() { return userId; }
    public void setUserId1(int userId) { this.userId = userId; }
    public String getUsername1() { return username; }
    public void setUsername1(String username) { this.username = username; }
    public String getPassword1() { return password; }
    public void setPassword1(String password) { this.password = password; }
    public String getRole1() { return role; }
    public void setRole1(String role) { this.role = role; }


    // Getters and Setters

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
