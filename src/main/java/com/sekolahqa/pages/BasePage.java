package com.sekolahqa.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class BasePage {
    private static WebDriver driver;
    private static Properties properties = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void inputText(By by, String text) throws InterruptedException {
        WebElement element = driver.findElement(by);
        Thread.sleep(200);
        element.sendKeys(text);
    }

    public static void clickButton(By by) throws InterruptedException {
        WebElement element = driver.findElement(by);
        Thread.sleep(100);
        element.click();
    }

    public static By waitUntilElementIsVisible(By by) throws InterruptedException {
        Thread.sleep(300);
        WebElement element = driver.findElement(by);
        return by;
    }

    public static void uploadFile (By by) throws InterruptedException {
        WebElement uploadElement = driver.findElement(by);
        uploadElement.sendKeys("D:\\Java\\Program\\bigProject\\assets\\dummy.png");
        Thread.sleep(1000);
    }

    public static void verifyText (By by, String text) throws InterruptedException{
        String bodyText = driver.findElement(by).getText();
        Assert.assertEquals(text,bodyText);
        Thread.sleep(1000);
    }

    public static void selectOption(By by, String option) throws InterruptedException{
        Select dropDown = new Select(driver.findElement(by));
        Thread.sleep(1000);
        dropDown.selectByVisibleText(option);
    }

    public void enterInTextBox(By by) throws InterruptedException{
        WebElement textBox = driver.findElement(by);
        Thread.sleep(1000);
        textBox.sendKeys(Keys.ENTER);
    }

    public void clearTextBox(By by) throws InterruptedException{
        WebElement textBox = driver.findElement(by);
        Thread.sleep(1000);
        textBox.clear();
    }

    public String getText(By by)throws InterruptedException{
        String text = driver.findElement(by).getText();
        Thread.sleep(1000);
        return text;
    }
}

