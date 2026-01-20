package com.jdbcconnectivity.Employee_Payroll_System.Util;

import com.jdbcconnectivity.Employee_Payroll_System.model.Salary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class SalaryPdfUtil {

    public static void generateSalarySlipPdf(Salary s) {

        String fileName = "SalarySlip_Emp_" + s.getEmpId() + "_" + s.getSalaryMonth() + ".pdf";

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream content =
                    new PDPageContentStream(document, page);

            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 16);
            content.setLeading(18f);
            content.newLineAtOffset(50, 750);

            content.showText("EMPLOYEE SALARY SLIP");
            content.newLine();
            content.newLine();

            content.setFont(PDType1Font.HELVETICA, 12);
            content.showText("Employee ID : " + s.getEmpId());
            content.newLine();
            content.showText("Salary Month : " + s.getSalaryMonth());
            content.newLine();
            content.newLine();

            content.showText("Basic Salary : " + s.getBasicSalary());
            content.newLine();
            content.showText("HRA          : " + s.getHra());
            content.newLine();
            content.showText("DA           : " + s.getDa());
            content.newLine();
            content.showText("PF           : " + s.getPf());
            content.newLine();
            content.showText("Tax          : " + s.getTax());
            content.newLine();
            content.newLine();

            content.showText("Gross Salary : " + s.getGrossSalary());
            content.newLine();
            content.showText("Net Salary   : " + s.getNetSalary());

            content.endText();
            content.close();

            document.save(fileName);
            System.out.println("✅ PDF Salary Slip Generated: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
