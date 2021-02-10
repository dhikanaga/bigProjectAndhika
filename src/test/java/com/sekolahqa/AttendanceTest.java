package com.sekolahqa;

import com.sekolahqa.config.Utils;
import com.sekolahqa.pages.Attendance;
import com.sekolahqa.testData.LoginTestData;
import com.sekolahqa.testData.PunchInTestData;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AttendanceTest {
    WebDriver driver = Utils.getDriver();

    public AttendanceTest() throws IOException {
    }

    @Test
    public void adminSuccesfullyPunchIn()throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        LoginTestData loginTestData = new LoginTestData(driver);
        loginTestData.successLogin("Admin", "s3Kol4HQA!*");
        Attendance attendance = new Attendance(driver);
        attendance.clickTime();
        attendance.clickPunch();
        attendance.inputNote("Testing punch in");
        attendance.clickButtonIn();
        Utils.closeWebsite();
    }

    @Test
    public void adminSuccesfullyPunchOut() throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        LoginTestData loginTestData = new LoginTestData(driver);
        loginTestData.successLogin("Admin", "s3Kol4HQA!*");
        PunchInTestData punchIn = new PunchInTestData(driver);
        punchIn.succesPunchIn();
        Attendance attendance = new Attendance(driver);
        attendance.inputNote("Testing punch out");
        attendance.clickButtonOut();
        Utils.closeWebsite();
    }

    @Test
    public void employeeSuccesfullyPunchIn()throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        LoginTestData loginTestData = new LoginTestData(driver);
        loginTestData.successLogin("DhikaTest", "s3Kol4HQA!*");
        Attendance attendance = new Attendance(driver);
        attendance.clickTime();
        attendance.clickPunch();
        attendance.inputNote("Testing punch in");
        attendance.clickButtonIn();
        Utils.closeWebsite();
    }

    @Test
    public void employeeSuccesfullyPunchOut() throws IOException, InterruptedException{
        Utils.openWebsite(Utils.getUrl());
        LoginTestData loginTestData = new LoginTestData(driver);
        loginTestData.successLogin("DhikaTest", "s3Kol4HQA!*");
        PunchInTestData punchIn = new PunchInTestData(driver);
        punchIn.succesPunchIn();
        Attendance attendance = new Attendance(driver);
        attendance.inputNote("Testing punch out");
        attendance.clickButtonOut();
        Utils.closeWebsite();
    }
}
