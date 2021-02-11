package com.sekolahqa;

import com.sekolahqa.config.Utils;
import com.sekolahqa.pages.Reports;
import com.sekolahqa.testData.LoginTestData;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ReportsTest {
    String employeeName = "Dhika";
    String fieldGroup = "Personal";
    String fieldList = "Employee Id";

    WebDriver driver = Utils.getDriver();

    public ReportsTest() throws IOException { }

    @Test
    public void adminAddNewReport() throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        LoginTestData login = new LoginTestData(driver);
        login.successLogin("Admin", "s3Kol4HQA!*");
        Reports reports = new Reports(driver);
        reports.adminGoToReportsPage();
        reports.clickButtonAdd();
        reports.inputReportName(employeeName+" Report");
        reports.addCriteria();
        reports.inputReportEmployeeName(employeeName);
        reports.addAllFromFieldGroup(fieldGroup);
        reports.clickSaveButton();
        Utils.closeWebsite();
    }

    @Test
    public void adminSearchNewReport() throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        LoginTestData login = new LoginTestData(driver);
        login.successLogin("Admin", "s3Kol4HQA!*");
        Reports reports = new Reports(driver);
        reports.adminGoToReportsPage();
        reports.inputSearchReport(employeeName+" Report");
        reports.clickSearch();
        Thread.sleep(2000);
        reports.verifySearchResult(employeeName+" Report");
        Utils.closeWebsite();
    }
}
