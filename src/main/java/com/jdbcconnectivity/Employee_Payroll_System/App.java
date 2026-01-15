package com.jdbcconnectivity.Employee_Payroll_System;
import com.jdbcconnectivity.Employee_Payroll_System.Util.*;
import com.jdbcconnectivity.Employee_Payroll_System.Menu.*;

public class App {
    public static void main(String[] args) {
        // create tables if not exist
        DataBaseUtil.createTables();
        System.out.println("Database ready.");

        MasterMenu menu = new MasterMenu();
        menu.startMenu();
    }
}