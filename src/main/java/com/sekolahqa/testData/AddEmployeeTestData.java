package com.sekolahqa.testData;

import com.sekolahqa.pages.AddEmployee;
import com.sekolahqa.pages.Auth;
import com.sekolahqa.pages.Leave;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AddEmployeeTestData {
    private AddEmployee add;

    public AddEmployeeTestData(WebDriver driver){
        add = new AddEmployee(driver);
    }

    public void successAddEmployee(String firstName, String middleName, String lasName) throws InterruptedException {
        add.userGoToAddEmployeePage();
        add.inputFirstName(firstName);
        add.inputMiddleName(middleName);
        add.inputLastName(lasName);
        add.uploadPhotograph();
        add.selectCreateLogin();
        add.inputUsername(firstName+lasName);
        add.inputPassword("s3Kol4HQA!*");
        add.confirmPassword("s3Kol4HQA!*");
        add.clickSaveButton();
    }
}
