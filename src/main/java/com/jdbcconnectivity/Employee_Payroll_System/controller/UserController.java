package com.jdbcconnectivity.Employee_Payroll_System.controller;
import com.jdbcconnectivity.Employee_Payroll_System.Services.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;

public class UserController {
    private UserService service = new UserService();

    public boolean registerUser(User u) { return service.registerUser(u); }
    public User login(String username, String password) { return service.login(username, password); }
}

