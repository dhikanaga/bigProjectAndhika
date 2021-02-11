package com.sekolahqa;

import com.sekolahqa.config.Utils;
import com.sekolahqa.pages.AddEmployee;
import com.sekolahqa.testData.LoginTestData;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AddEmployeeTest {
    String firstname= "Dhika";
    String middlename= "Test";
    String lastname= "1";


    WebDriver driver = Utils.getDriver();

    public AddEmployeeTest() throws IOException {
    }

    @Test
    public void successfullyAddEmployee()throws InterruptedException,IOException{
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        LoginTestData login = new LoginTestData(driver);
        login.successLogin("Admin","s3Kol4HQA!*");
        AddEmployee add = new AddEmployee(driver);
        add.userGoToAddEmployeePage();
        add.inputFirstName(firstname);
        add.inputMiddleName(middlename);
        add.inputLastName(lastname);
        add.uploadPhotograph();
        add.selectCreateLogin();
        add.inputUsername(firstname+lastname);
        add.inputPassword("s3Kol4HQA!*");
        add.confirmPassword("s3Kol4HQA!*");
        add.clickSaveButton();
        Thread.sleep(2000);
        add.verifyNewEmployeeName(firstname+" "+middlename+" "+lastname);
        Utils.closeWebsite();
    }
}
