package com.sekolahqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Auth extends BasePage{
    private By formUserName = new By.ByXPath("//*[@id='txtUsername']");
    private By formPassword = new By.ByXPath("//*[@id='txtPassword']");
    private By btnLogin = new By.ByXPath("//*[@id='btnLogin']");
    private By errorMessage = new By.ByXPath("//*[@id='spanMessage']");
    private By pnlWelcome = new By.ByXPath("//*[@id='welcome']");
    private By btnLogout = new By.ByXPath("//*[@id='welcome-menu']/ul/li[3]/a");

    public Auth (WebDriver driver) {super (driver);}

    public void inputUsername(String username) throws InterruptedException{
        inputText(formUserName, username);
    }

    public void inputPassword(String password) throws InterruptedException{
        inputText(formPassword, password);
    }

    public void clickLogin() throws InterruptedException{
        clickButton(btnLogin);
    }

    public void userSeeErrorMessage() throws InterruptedException{
        waitUntilElementIsVisible(errorMessage);
    }

    public void clickLogout()throws InterruptedException{
        clickButton(pnlWelcome);
        clickButton(btnLogout);
    }

    public String getErrorText() throws InterruptedException {
        return getText(errorMessage);
    }
}
