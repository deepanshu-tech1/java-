package com.jdbcconnectivity.Employee_Payroll_System.Menu;

import com.jdbcconnectivity.Employee_Payroll_System.controller.*;
import com.jdbcconnectivity.Employee_Payroll_System.model.*;

import java.util.*;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;    // <-- import
import java.util.logging.Logger; 

public class MasterMenu {
	 static {
	        Logger.getLogger("org.apache.pdfbox").setLevel(Level.SEVERE);
	    }
    private Scanner sc = new Scanner(System.in);

    private EmployeeController empCtrl = new EmployeeController();
    private AttendanceController attCtrl = new AttendanceController();
    private SalaryController salCtrl = new SalaryController();
    private BonusDeductionController bdCtrl = new BonusDeductionController();
    private PayrollController payrollCtrl = new PayrollController();
    private ReportController reportCtrl = new ReportController();
    private UserController userCtrl = new UserController();

    // ... rest of your menu code

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

    // ================= SALARY MENU (UPDATED) =================
    private void salaryMenu() {
        while (true) {
            System.out.println("\n--- Salary Menu ---");
            System.out.println("1. Add Salary");
            System.out.println("2. View Salary by Employee");
            System.out.println("3. View Salary by Salary ID");
            System.out.println("4. Generate Salary Slip PDF");
            System.out.println("0. Back");
            System.out.print("Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    addSalary();
                    break;

                case 2:
                    System.out.print("Emp ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    for (Salary s : salCtrl.getSalaryByEmployee(empId)) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Salary ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.println(salCtrl.getSalaryById(sid));
                    break;

                case 4:   // 🔥 PDF GENERATION
                    System.out.print("Enter Salary ID: ");
                    int salaryId = sc.nextInt();
                    sc.nextLine();
                    salCtrl.generateSalarySlipPdf(salaryId);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // ================= ADD SALARY =================
    private void addSalary() {
        try {
            System.out.print("Salary ID: ");
            int sid = Integer.parseInt(sc.nextLine());

            System.out.print("Emp ID: ");
            int empId = Integer.parseInt(sc.nextLine());

            System.out.print("Basic Salary: ");
            double basic = Double.parseDouble(sc.nextLine());

            System.out.print("HRA: ");
            double hra = Double.parseDouble(sc.nextLine());

            System.out.print("DA: ");
            double da = Double.parseDouble(sc.nextLine());

            System.out.print("PF: ");
            double pf = Double.parseDouble(sc.nextLine());

            System.out.print("Tax: ");
            double tax = Double.parseDouble(sc.nextLine());

            double gross = basic + hra + da;
            double net = gross - pf - tax;

            System.out.print("Salary Month (yyyy-mm): ");
            String month = sc.nextLine();

            Salary s = new Salary(
                    sid, empId, basic, hra, da, pf, tax, gross, net, month
            );

            System.out.println(salCtrl.addSalary(s) ? "Salary Added" : "Failed");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================= OTHER MENUS (UNCHANGED) =================
    private void employeeMenu() { /* YOUR EXISTING CODE */ }
    private void attendanceMenu() { /* YOUR EXISTING CODE */ }
    private void bonusMenu() { /* YOUR EXISTING CODE */ }
    private void payrollMenu() { /* YOUR EXISTING CODE */ }
    private void reportsMenu() { /* YOUR EXISTING CODE */ }
    private void userMenu() { /* YOUR EXISTING CODE */ }
}
