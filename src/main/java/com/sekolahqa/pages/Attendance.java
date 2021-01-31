package com.sekolahqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Attendance extends BasePage{
    private By menuTime = new By.ByXPath("//*[@id='menu_time_viewTimeModule']");
    private By optionAttendance = new By.ByXPath("//*[@id='menu_attendance_Attendance']");
    private By punch = new By.ByXPath("//*[@id='menu_attendance_punchIn']");
    private By fieldNote = new By.ByXPath("//*[@id='note']");
    private By btnIn = new By.ByXPath("//*[@id='btnPunch']");

    public Attendance(WebDriver driver) { super(driver); }

    public void clickTime() throws InterruptedException{
        clickButton(menuTime);
    }

    public void clickPunch() throws InterruptedException{
        clickButton(optionAttendance);
        clickButton(punch);
    }

    public void inputNote(String note) throws InterruptedException{
        inputText(fieldNote,note);
    }

    public void clickButtonIn() throws InterruptedException{
        clickButton(btnIn);
    }
}
