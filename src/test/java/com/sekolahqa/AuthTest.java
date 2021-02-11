package com.sekolahqa;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sekolahqa.config.Utils;
import com.sekolahqa.pages.Auth;

import com.sekolahqa.testData.sendEmailReport;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthTest {
    WebDriver driver = Utils.getDriver();
    private static ExtentReports extent;
    private static ExtentTest test;

    public AuthTest() throws IOException{
    }

    String filePath= "D:\\Java\\Program\\bigProject\\reports\\AuthenticationTestResult.html";

    @BeforeTest
    public void makeReports() throws InterruptedException{
        extent = new ExtentReports(filePath, true);
    }

    @Test
    public void adminSussesfullyLogin() throws InterruptedException, IOException {
        test = extent.startTest("Admin Success Login");
        Utils.openWebsite(Utils.getUrl());
        test.log(LogStatus.PASS, "Browser is open and go to Site");
        Thread.sleep(2000);
        Auth auth = new Auth(driver);
        auth.inputUsername("Admin");
        test.log(LogStatus.PASS,"Admin input Username");
        auth.inputPassword("s3Kol4HQA!*");
        test.log(LogStatus.PASS,"Admin input Password");
        auth.clickLogin();
        test.log(LogStatus.PASS,"Admin click Login");
        Thread.sleep(2000);
        test.log(LogStatus.PASS,"Admin logged in");
        Utils.closeWebsite();

    }

    @Test
    public void adminFailedLogin() throws InterruptedException, IOException {
        test = extent.startTest("Admin Failed Login");
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        test.log(LogStatus.PASS, "Browser is open and go to Site");
        Auth auth = new Auth(driver);
        auth.inputUsername("NotAdmin");
        test.log(LogStatus.PASS,"Admin input wrong username");
        auth.inputPassword("TestTest");
        test.log(LogStatus.PASS,"Admin input wrong password");
        auth.clickLogin();
        test.log(LogStatus.PASS,"Admin click login");
        auth.userSeeErrorMessage();
        test.log(LogStatus.INFO,"Admin see error "+auth.getErrorText());
        Thread.sleep(2000);
        Utils.closeWebsite();
    }

    @AfterTest
    public void flushReport() throws InterruptedException, EmailException {
        extent.endTest(test);
        extent.flush();
        sendEmailReport send = new sendEmailReport();
        send.sendAttachedEmail(filePath, "Report of Login", "Auth Test", test.getTest().getName());
    }
}
