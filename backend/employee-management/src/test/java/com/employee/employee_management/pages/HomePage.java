package com.employee.employee_management.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // initializes @FindBy elements
    }

    // Input fields
    @FindBy(name = "firstName")
    WebElement firstNameField;

    @FindBy(name = "lastName")
    WebElement lastNameField;

    @FindBy(name = "email")
    WebElement emailField;

    // Add button
    @FindBy(xpath = "//button[text()='Add']")
    WebElement addButton;

    // Toast notification
    @FindBy(className = "Toastify__toast")
    List<WebElement> toastMessages;

    public void enterDetails(String fn, String ln, String em) {
        firstNameField.clear();
        firstNameField.sendKeys(fn);

        lastNameField.clear();
        lastNameField.sendKeys(ln);

        emailField.clear();
        emailField.sendKeys(em);
    }

    public void clickAdd() {
        addButton.click();
    }

    public boolean isEmployeePresent(String text) {
        return driver.getPageSource().contains(text);
    }

    public void deleteByEmail(String emailText) {
        List<WebElement> rows = driver.findElements(By.xpath("//tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(emailText)) {
                WebElement deleteBtn = row.findElement(By.xpath(".//button[text()='Delete']"));
                deleteBtn.click();
                Alert alert = driver.switchTo().alert();
                alert.accept();
                break;
            }
        }
    }

    public boolean isToastVisible() {
        return !toastMessages.isEmpty();
    }
}
