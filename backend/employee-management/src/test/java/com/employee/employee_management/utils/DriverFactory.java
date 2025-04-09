package com.employee.employee_management.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initDriver() {
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\manis\\Downloads\\geckodriver-v0.35.0-win32\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
