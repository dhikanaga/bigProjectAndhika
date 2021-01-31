package com.sekolahqa;

import com.sekolahqa.config.Utils;
import com.sekolahqa.pages.Attendance;
import com.sekolahqa.testData.LoginTestData;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AttendanceTest {
    WebDriver driver = Utils.getDriver();

    public AttendanceTest() throws IOException {
    }

    @Test
    public void userSuccesfullyPunchIn()throws IOException, InterruptedException{
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
}
