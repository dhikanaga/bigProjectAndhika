package com.sekolahqa;

import com.sekolahqa.config.Utils;
import com.sekolahqa.pages.Leave;
import com.sekolahqa.testData.AddEmployeeTestData;
import com.sekolahqa.testData.LoginTestData;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import java.io.IOException;

public class LeaveTest {
    String firstname= "Dhika";
    String middlename= "Test";
    String lastname= "10";
    String typeOfLeave= "Cuti";
    String balance = "5.00";

    Date dt = new Date();
    DateTime dtOrg = new DateTime(dt);
    DateTimeFormatter formatted = DateTimeFormat.forPattern("yyyy-MM-dd");
    String fromDate = formatted.print(dtOrg.plusDays(1));
    String toDate = formatted.print(dtOrg.plusDays(2));
    String wrongToDate = formatted.print((dtOrg.minusDays(3)));


    WebDriver driver = Utils.getDriver();

    public LeaveTest() throws IOException {
    }

    @Test
    public void adminGiveEntitlements() throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        LoginTestData login = new LoginTestData(driver);
        login.successLogin("Admin","s3Kol4HQA!*");
        AddEmployeeTestData add = new AddEmployeeTestData(driver);
        add.successAddEmployee(firstname, middlename,lastname);
        Thread.sleep(2000);
        Leave leave = new Leave(driver);
        leave.adminGoToEntitlements();
        Thread.sleep(2000);
        leave.adminInputEmployeeName(firstname+" "+middlename+" "+lastname);
        leave.adminSelectLeaveType(typeOfLeave);
        leave.adminInputLeaveBalance(balance);
        leave.clickButtonSave();
        Thread.sleep(3000);
        Utils.closeWebsite();
    }

    @Test
    public void employeeSuccessApplyLeave() throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        LoginTestData login = new LoginTestData(driver);
        login.successLogin(firstname+lastname,"s3Kol4HQA!*");
        Thread.sleep(2000);
        Leave leave = new Leave(driver);
        leave.employeeGoToLeavePage();
        leave.employeeSelectLeaveType(typeOfLeave);
        leave.employeeSetFromDate(fromDate);
        leave.employeeSetToDate(toDate);
        leave.employeeInputComment(firstname+lastname+" new Leave");
        leave.clickApplyButton();
        Utils.closeWebsite();
    }

    @Test
    public void employeeFailedApplyLeave() throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        LoginTestData login = new LoginTestData(driver);
        login.successLogin(firstname+lastname,"s3Kol4HQA!*");
        Thread.sleep(2000);
        Leave leave = new Leave(driver);
        leave.employeeGoToLeavePage();
        leave.employeeSelectLeaveType(typeOfLeave);
        leave.employeeSetFromDate(fromDate);
        leave.employeeSetToDate(wrongToDate);
        leave.userSeeErrorMessage();
        Utils.closeWebsite();
    }
}
