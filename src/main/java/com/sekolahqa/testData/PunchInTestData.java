package com.sekolahqa.testData;

import com.sekolahqa.pages.Attendance;
import com.sekolahqa.pages.Auth;
import org.openqa.selenium.WebDriver;

public class PunchInTestData {

    private Attendance attendance;

    public PunchInTestData(WebDriver driver){
        attendance = new Attendance(driver);
    }

    public void succesPunchIn() throws InterruptedException{
        attendance.clickTime();
        Thread.sleep(2000);
        attendance.clickPunch();
        attendance.inputNote("Testing punch in");
        attendance.clickButtonIn();
    }
}
