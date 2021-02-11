package com.sekolahqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AddEmployee extends BasePage{
    private By menuPIM = new By.ByXPath("//*[@id='menu_pim_viewPimModule']");
    private By menuAddEmployee = new By.ByXPath("//*[@id='menu_pim_addEmployee']");
    private By firstName = new By.ByXPath("//*[@id='firstName']");
    private By middleName = new By.ByXPath("//*[@id='middleName']");
    private By lastName = new By.ByXPath("//*[@id='lastName']");
    private By photograph = new By.ByXPath("//*[@id='photofile']");
    private By checkLoginDetails = new By.ByXPath("//*[@id='chkLogin']");
    private By employeeUsername = new By.ByXPath("//*[@id='user_name']");
    private By employeePassword = new By.ByXPath("//*[@id='user_password']");
    private By confirmPassword = new By.ByXPath("//*[@id='re_password']");
    private By btnSave = new By.ByXPath("//*[@id='btnSave']");
    private By employeeName = new By.ByXPath("//*[@id='profile-pic']/h1");

    public AddEmployee(WebDriver driver) {
        super(driver);
    }

    public void userGoToAddEmployeePage()throws InterruptedException{
        clickButton(menuPIM);
        clickButton(menuAddEmployee);
    }

    public void inputFirstName(String first)throws InterruptedException{
        inputText(firstName,first);
    }

    public void inputMiddleName(String middle)throws InterruptedException{
        inputText(middleName,middle);
    }

    public void inputLastName(String last)throws InterruptedException{
        inputText(lastName,last);
    }

    public void uploadPhotograph() throws InterruptedException {
        uploadFile(photograph);
    }

    public void selectCreateLogin()throws InterruptedException{
        clickButton(checkLoginDetails);
    }

    public void inputUsername(String username)throws InterruptedException{
        inputText(employeeUsername,username);
    }

    public void inputPassword(String password)throws InterruptedException{
        inputText(employeePassword,password);
    }

    public void confirmPassword(String rePassword)throws InterruptedException{
        inputText(confirmPassword,rePassword);
    }

    public void clickSaveButton()throws InterruptedException{
        clickButton(btnSave);
    }

    public void verifyNewEmployeeName(String fullName) throws InterruptedException{
        verifyText(employeeName, fullName);
    }
}
