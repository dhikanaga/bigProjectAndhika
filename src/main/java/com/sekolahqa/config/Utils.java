package com.sekolahqa.config;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    private static WebDriver driver;
    private static Properties properties = new Properties();

    public static WebDriver getDriver() throws IOException {
        InputStream input = new FileInputStream("properties/browser.properties");
        properties.load(input);
        System.setProperty(properties.getProperty("DRIVER_NAME"), properties.getProperty("Chrome_DRIVER_PATH"));
        driver = new ChromeDriver();
        return driver;
    }

    public static String getUrl()  throws IOException {
        InputStream input = new FileInputStream("properties/browser.properties");
        properties.load(input);
        String url = properties.getProperty("WEB_URL");
        return url;
    }

        @Before
    public static void openWebsite(String websiteUrl) throws InterruptedException {
        driver.navigate().to(websiteUrl);
        Thread.sleep(500);
    }

    public static void closeWebsite() {
        driver.close();
        driver.quit();
    }
}
