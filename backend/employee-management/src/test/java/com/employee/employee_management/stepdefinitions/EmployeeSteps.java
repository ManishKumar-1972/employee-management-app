package com.employee.employee_management.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import com.employee.employee_management.pages.HomePage;
import com.employee.employee_management.utils.DriverFactory;

import static org.junit.Assert.*;

public class EmployeeSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage home;

    @Given("I open the employee management application")
    public void i_open_app() {
        driver.get("http://localhost:3000");
        home = new HomePage(driver);
    }

    @When("I enter {string} in first name, {string} in last name, and {string} in email")
    public void i_enter_employee_details(String fn, String ln, String em) {
        home.enterDetails(fn, ln, em);
    }

    @When("I click on the Add button")
    public void i_click_add_button() {
        home.clickAdd();
    }

    @Then("I should see {string} in the employee list")
    public void i_should_see_in_list(String name) {
        assertTrue(home.isEmployeePresent(name));
    }

    @When("I click on the Add button without filling anything")
    public void click_add_empty() {
        home.clickAdd();
    }

    @Then("I should see an error toast")
    public void i_see_error_toast() {
        assertTrue(home.isToastVisible());
    }

    @When("I delete the employee with email {string}")
    public void i_delete_by_email(String email) {
        home.deleteByEmail(email);
    }

    @Then("I should not see {string} in the list")
    public void i_should_not_see(String name) {
        assertFalse(home.isEmployeePresent(name));
    }
}
