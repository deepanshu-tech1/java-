package com.jdbcconnectivity.Employee_Payroll_System.Util;

import com.jdbcconnectivity.Employee_Payroll_System.model.Salary;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class SalaryExcelUtil {

    public static void generateSalarySlip(Salary s) {

        String fileName = "SalarySlip_Emp_" + s.getEmpId() + "_" + s.getSalaryMonth() + ".xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Salary Slip");

            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            String[][] data = {
                    {"Employee ID", String.valueOf(s.getEmpId())},
                    {"Salary Month", s.getSalaryMonth()},
                    {"Basic Salary", String.valueOf(s.getBasicSalary())},
                    {"HRA", String.valueOf(s.getHra())},
                    {"DA", String.valueOf(s.getDa())},
                    {"PF", String.valueOf(s.getPf())},
                    {"Tax", String.valueOf(s.getTax())},
                    {"Gross Salary", String.valueOf(s.getGrossSalary())},
                    {"Net Salary", String.valueOf(s.getNetSalary())}
            };

            int rowNum = 0;
            for (String[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                Cell c1 = row.createCell(0);
                c1.setCellValue(rowData[0]);
                c1.setCellStyle(headerStyle);
                row.createCell(1).setCellValue(rowData[1]);
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();

            System.out.println("✅ Excel Salary Slip Generated: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
