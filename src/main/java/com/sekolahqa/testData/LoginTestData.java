package com.sekolahqa.testData;

import com.sekolahqa.pages.Auth;
import org.openqa.selenium.WebDriver;

public class LoginTestData {
    private Auth auth;

    public LoginTestData(WebDriver driver){
        auth = new Auth(driver);
    }

    public void successLogin(String username, String password) throws InterruptedException{
        auth.inputUsername(username);
        auth.inputPassword(password);
        auth.clickLogin();
    }
}
