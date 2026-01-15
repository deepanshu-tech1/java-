package com.jdbcconnectivity.Employee_Payroll_System.Menu;
import com.jdbcconnectivity.Employee_Payroll_System.controller.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;
import java.util.*;


import java.sql.Date;
import java.sql.Time;

public class MasterMenu {

    private Scanner sc = new Scanner(System.in);

    private EmployeeController empCtrl = new EmployeeController();
    private AttendanceController attCtrl = new AttendanceController();
    private SalaryController salCtrl = new SalaryController();
    private BonusDeductionController bdCtrl = new BonusDeductionController();
    private PayrollController payrollCtrl = new PayrollController();
    private ReportController reportCtrl = new ReportController();
    private UserController userCtrl = new UserController();

    public void startMenu() {
        while (true) {
            System.out.println("\n===== EMPLOYEE PAYROLL =====");
            System.out.println("1. Employee Management");
            System.out.println("2. Attendance Management");
            System.out.println("3. Salary Management");
            System.out.println("4. Bonus & Deduction");
            System.out.println("5. Payroll");
            System.out.println("6. Reports");
            System.out.println("7. User Management");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: employeeMenu(); break;
                case 2: attendanceMenu(); break;
                case 3: salaryMenu(); break;
                case 4: bonusMenu(); break;
                case 5: payrollMenu(); break;
                case 6: reportsMenu(); break;
                case 7: userMenu(); break;
                case 0: System.out.println("Bye"); return;
                default: System.out.println("Invalid");
            }
        }
    }

    // ---------------- Employee submenu ----------------
    private void employeeMenu() {
        while (true) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    System.out.print("Enter emp id: "); int id = sc.nextInt(); sc.nextLine();
                    Employee e = empCtrl.getEmployeeById(id);
                    System.out.println(e == null ? "Not found" : e);
                    break;
                case 3:
                    for (Employee emp : empCtrl.getAllEmployees()) System.out.println(emp);
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    System.out.print("Enter emp id to delete: "); int delId = sc.nextInt(); sc.nextLine();
                    System.out.println(empCtrl.deleteEmployee(delId) ? "Deleted" : "Failed");
                    break;
                case 0: return;
                default: System.out.println("Invalid");
            }
        }
    }

    private void addEmployee() {
        try {
            System.out.print("Emp ID: "); int id = Integer.parseInt(sc.nextLine());
            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Contact(10 digits): "); String contact = sc.nextLine();
            System.out.print("Gender: "); String gender = sc.nextLine();
            System.out.print("DOB (yyyy-mm-dd): "); Date dob = Date.valueOf(sc.nextLine());
            System.out.print("Address: "); String addr = sc.nextLine();
            System.out.print("Department: "); String dept = sc.nextLine();
            System.out.print("Designation: "); String desig = sc.nextLine();
            System.out.print("Date of Joining (yyyy-mm-dd): "); Date doj = Date.valueOf(sc.nextLine());

            Employee emp = new Employee(id, name, contact, gender, dob, addr, dept, desig, doj);
            System.out.println(empCtrl.addEmployee(emp) ? "Added" : "Failed");
        } catch (Exception ex) {
            System.out.println("Invalid input: " + ex.getMessage());
        }
    }

    private void updateEmployee() {
        try {
            System.out.print("Emp ID to update: "); int id = Integer.parseInt(sc.nextLine());
            Employee existing = empCtrl.getEmployeeById(id);
            if (existing == null) { System.out.println("Not found"); return; }

            System.out.print("New Name ("+existing.getEmpName()+"): "); String name = sc.nextLine(); if (!name.isBlank()) existing.setEmpName(name);
            System.out.print("New Contact ("+existing.getContact()+"): "); String contact = sc.nextLine(); if (!contact.isBlank()) existing.setContact(contact);
            System.out.print("New Department ("+existing.getDepartment()+"): "); String dept = sc.nextLine(); if (!dept.isBlank()) existing.setDepartment(dept);
            System.out.print("New Designation ("+existing.getDesignation()+"): "); String desig = sc.nextLine(); if (!desig.isBlank()) existing.setDesignation(desig);

            System.out.println(empCtrl.updateEmployee(existing) ? "Updated" : "Failed");
        } catch (Exception ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    // ---------------- Attendance submenu ----------------
    private void attendanceMenu() {
        while (true) {
            System.out.println("\n--- Attendance Menu ---");
            System.out.println("1. Mark Attendance (Check-in)");
            System.out.println("2. View Attendance by Employee");
            System.out.println("3. Update Check-out time");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1: markAttendance(); break;
                case 2:
                    System.out.print("Emp id: "); int id = sc.nextInt(); sc.nextLine();
                    for (Attendance a : attCtrl.getAttendanceByEmployee(id)) System.out.println(a);
                    break;
                case 3:
                    System.out.print("Attendance ID: "); int aid = sc.nextInt(); sc.nextLine();
                    System.out.print("Check-out time (HH:MM:SS): "); String out = sc.nextLine();
                    System.out.println(attCtrl.updateCheckOut(aid, out) ? "Updated" : "Failed");
                    break;
                case 0: return;
                default: System.out.println("Invalid");
            }
        }
    }

    private void markAttendance() {
        try {
            System.out.print("Attendance ID: "); int aid = Integer.parseInt(sc.nextLine());
            System.out.print("Emp ID: "); int empId = Integer.parseInt(sc.nextLine());
            System.out.print("Date (yyyy-mm-dd): "); Date date = Date.valueOf(sc.nextLine());
            System.out.print("Check-in time (HH:MM:SS) or leave blank: "); String in = sc.nextLine();
            Time checkIn = in.isBlank() ? null : Time.valueOf(in);
            Time checkOut = null;
            System.out.print("Status (Present/Absent): "); String status = sc.nextLine();
            double hours = 0.0;
            Attendance a = new Attendance(aid, empId, date, checkIn, checkOut, status, hours);
            System.out.println(attCtrl.markAttendance(a) ? "Marked" : "Failed");
        } catch (Exception ex) { System.out.println("Invalid input: "+ex.getMessage()); }
    }

    // ---------------- Salary submenu ----------------
    private void salaryMenu() {
        while (true) {
            System.out.println("\n--- Salary Menu ---");
            System.out.println("1. Add Salary");
            System.out.println("2. View Salary by Employee");
            System.out.println("3. View Salary by Salary ID");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1: addSalary(); break;
                case 2:
                    System.out.print("Emp id: "); int id = sc.nextInt(); sc.nextLine();
                    for (Salary s : salCtrl.getSalaryByEmployee(id)) System.out.println(s);
                    break;
                case 3:
                    System.out.print("Salary id: "); int sid = sc.nextInt(); sc.nextLine();
                    System.out.println(salCtrl.getSalaryById(sid));
                    break;
                case 0: return;
                default: System.out.println("Invalid");
            }
        }
    }

    private void addSalary() {
        try {
            System.out.print("Salary ID: "); int sid = Integer.parseInt(sc.nextLine());
            System.out.print("Emp ID: "); int empId = Integer.parseInt(sc.nextLine());
            System.out.print("Basic Salary: "); double basic = Double.parseDouble(sc.nextLine());
            System.out.print("HRA: "); double hra = Double.parseDouble(sc.nextLine());
            System.out.print("DA: "); double da = Double.parseDouble(sc.nextLine());
            System.out.print("PF: "); double pf = Double.parseDouble(sc.nextLine());
            System.out.print("Tax: "); double tax = Double.parseDouble(sc.nextLine());
            double gross = basic + hra + da;
            double net = gross - pf - tax;
            System.out.print("Salary Month (e.g. 2025-12): "); String month = sc.nextLine();
            Salary s = new Salary(sid, empId, basic, hra, da, pf, tax, gross, net, month);
            System.out.println(salCtrl.addSalary(s) ? "Added" : "Failed");
        } catch (Exception ex) { System.out.println("Error: "+ex.getMessage()); }
    }

    // ---------------- Bonus ----------------
    private void bonusMenu() {
        while (true) {
            System.out.println("\n--- Bonus & Deduction ---");
            System.out.println("1. Add Bonus/Deduction");
            System.out.println("2. View by Employee");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1:
                    addBonus();
                    break;
                case 2:
                    System.out.print("Emp id: "); int id = sc.nextInt(); sc.nextLine();
                    for (BonusDeduction b : bdCtrl.getAllByEmployee(id)) System.out.println(b);
                    break;
                case 0: return;
                default: System.out.println("Invalid");
            }
        }
    }

    private void addBonus() {
        try {
            System.out.print("BD ID: "); int bdId = Integer.parseInt(sc.nextLine());
            System.out.print("Emp ID: "); int empId = Integer.parseInt(sc.nextLine());
            System.out.print("Type (Bonus/Deduction): "); String type = sc.nextLine();
            System.out.print("Amount: "); double amt = Double.parseDouble(sc.nextLine());
            System.out.print("Reason (optional): "); String reason = sc.nextLine();
            java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
            System.out.print("Added By: "); String addedBy = sc.nextLine();
            BonusDeduction bd = new BonusDeduction(bdId, empId, type, amt, reason, date, addedBy);
            System.out.println(bdCtrl.addBonusDeduction(bd) ? "Added" : "Failed");
        } catch (Exception ex) { System.out.println("Error: " + ex.getMessage()); }
    }

    // ---------------- Payroll----------------
    private void payrollMenu() {
        while (true) {
            System.out.println("\n--- Payroll Menu ---");
            System.out.println("1. Generate Payroll (add)");
            System.out.println("2. View Payroll by Employee");
            System.out.println("3. View Payroll by ID");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1:
                    generatePayroll();
                    break;
                case 2:
                    System.out.print("Emp id: "); int id = sc.nextInt(); sc.nextLine();
                    for (Payroll p : payrollCtrl.getPayrollByEmployee(id)) System.out.println(p);
                    break;
                case 3:
                    System.out.print("Payroll id: "); int pid = sc.nextInt(); sc.nextLine();
                    System.out.println(payrollCtrl.getPayrollById(pid));
                    break;
                case 0: return;
                default: System.out.println("Invalid");
            }
        }
    }

    private void generatePayroll() {
        try {
            System.out.print("Payroll ID: "); int pid = Integer.parseInt(sc.nextLine());
            System.out.print("Emp ID: "); int empId = Integer.parseInt(sc.nextLine());
            System.out.print("Basic Salary: "); double basic = Double.parseDouble(sc.nextLine());
            System.out.print("Total Bonus: "); double bonus = Double.parseDouble(sc.nextLine());
            System.out.print("Total Deduction: "); double ded = Double.parseDouble(sc.nextLine());
            double net = basic + bonus - ded;
            System.out.print("Payroll Month (e.g. 2025-12): "); String month = sc.nextLine();
            java.sql.Timestamp genDate = new java.sql.Timestamp(System.currentTimeMillis());
            String status = "generated";
            Payroll p = new Payroll(pid, empId, basic, bonus, ded, net, month, genDate, status);
            System.out.println(payrollCtrl.addPayroll(p) ? "Generated" : "Failed");
        } catch (Exception ex) { System.out.println("Error: "+ex.getMessage()); }
    }

    // ---------------- Reports submenu ----------------
    private void reportsMenu() {
        while (true) {
            System.out.println("\n--- Reports Menu ---");
            System.out.println("1. Add Report");
            System.out.println("2. View All Reports");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1:
                    addReport();
                    break;
                case 2:
                    for (Report r : reportCtrl.getAllReports()) System.out.println(r);
                    break;
                case 0: return;
                default: System.out.println("Invalid");
            }
        }
    }

    private void addReport() {
        try {
            System.out.print("Report Type: "); String type = sc.nextLine();
            System.out.print("Month: "); String month = sc.nextLine();
            System.out.print("Year: "); int year = Integer.parseInt(sc.nextLine());
            System.out.print("Generated By: "); String genBy = sc.nextLine();
            System.out.print("File Path: "); String path = sc.nextLine();
            Report r = new Report(0, type, month, year, genBy, new java.sql.Timestamp(System.currentTimeMillis()), path);
            System.out.println(reportCtrl.addReport(r) ? "Added" : "Failed");
        } catch (Exception ex) { System.out.println("Error: " + ex.getMessage()); }
    }

    // ---------------- User submenu ----------------
    private void userMenu() {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1: registerUser(); break;
                case 2: loginUser(); break;
                case 0: return;
                default: System.out.println("Invalid");
            }
        }
    }

    private void registerUser() {
        try {
            System.out.print("User ID: "); int uid = Integer.parseInt(sc.nextLine());
            System.out.print("Username: "); String uname = sc.nextLine();
            System.out.print("Password: "); String pwd = sc.nextLine();
            System.out.print("Role (admin/user): "); String role = sc.nextLine();
            User u = new User(uid, uname, pwd, role);
            System.out.println(userCtrl.registerUser(u) ? "Registered" : "Failed");
        } catch (Exception ex) { System.out.println("Error: "+ex.getMessage()); }
    }

    private void loginUser() {
        try {
            System.out.print("Username: "); String uname = sc.nextLine();
            System.out.print("Password: "); String pwd = sc.nextLine();
            User u = userCtrl.login(uname, pwd);
            System.out.println(u == null ? "Invalid credentials" : "Login OK: " + u.getUsername() + " role:" + u.getRole());
        } catch (Exception ex) { System.out.println("Error: "+ex.getMessage()); }
    }
}
