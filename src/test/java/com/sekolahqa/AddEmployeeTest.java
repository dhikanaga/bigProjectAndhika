package com.sekolahqa;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sekolahqa.config.Utils;
import com.sekolahqa.pages.AddEmployee;
import com.sekolahqa.testData.LoginTestData;
import com.sekolahqa.testData.sendEmailReport;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddEmployeeTest {
    private static ExtentReports extent;
    private static ExtentTest test;
    String firstname= "Dhika";
    String middlename= "Test";
    String lastname= "2";


    WebDriver driver = Utils.getDriver();

    public AddEmployeeTest() throws IOException {
    }

    String filePath= "D:\\Java\\Program\\bigProject\\reports\\AddEmployeeTestResult.html";

    @BeforeTest
    public void makeReports() throws InterruptedException{
        extent = new ExtentReports(filePath, true);
    }

    @Test
    public void successfullyAddEmployee() throws InterruptedException, IOException {
        test = extent.startTest("Success Add Employee");
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        LoginTestData login = new LoginTestData(driver);
        login.successLogin("Admin","s3Kol4HQA!*");
        test.log(LogStatus.PASS,"Success Login as Admin");
        AddEmployee add = new AddEmployee(driver);
        add.userGoToAddEmployeePage();
        test.log(LogStatus.PASS,"Go to Add Employee Page");
        add.inputFirstName(firstname);
        test.log(LogStatus.PASS,"Input first name");
        add.inputMiddleName(middlename);
        test.log(LogStatus.PASS,"Input middle name");
        add.inputLastName(lastname);
        test.log(LogStatus.PASS,"Input last name");
        add.uploadPhotograph();
        test.log(LogStatus.PASS,"Upload dummy image");
        add.selectCreateLogin();
        test.log(LogStatus.PASS,"Select create login");
        add.inputUsername(firstname+lastname);
        add.inputPassword("s3Kol4HQA!*");
        add.confirmPassword("s3Kol4HQA!*");
        test.log(LogStatus.PASS,"Input employee username and password");
        add.clickSaveButton();
        test.log(LogStatus.PASS,"Click save button");
        Thread.sleep(2000);
        add.verifyNewEmployeeName(firstname+" "+middlename+" "+lastname);
        test.log(LogStatus.PASS,"Verify name of new employee");
        Utils.closeWebsite();
    }

    @AfterTest
    public void flushReport() throws EmailException {
        extent.endTest(test);
        extent.flush();
        sendEmailReport send = new sendEmailReport();
        send.sendAttachedEmail(filePath, "Report of Add Employee", "Add Employee Test", test.getTest().getName());
    }
}
