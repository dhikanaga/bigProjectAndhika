package com.sekolahqa;

import com.sekolahqa.config.Utils;
import com.sekolahqa.pages.Auth;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AuthTest {
    WebDriver driver = Utils.getDriver();

    public AuthTest() throws IOException{
    }

    @Test
    public void userSussesfullyLogin() throws InterruptedException, IOException {
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        Auth auth = new Auth(driver);
        auth.inputUsername("Admin");
        auth.inputPassword("s3Kol4HQA!*");
        auth.clickLogin();
        Thread.sleep(2000);
        Utils.closeWebsite();
    }

    @Test
    public void userFailedLogin() throws InterruptedException, IOException {
        Utils.openWebsite(Utils.getUrl());
        Thread.sleep(2000);
        Auth auth = new Auth(driver);
        auth.inputUsername("NotAdmin");
        auth.inputPassword("TestTest");
        auth.clickLogin();
        auth.userSeeErrorMessage();
        Thread.sleep(2000);
        Utils.closeWebsite();
    }
}
