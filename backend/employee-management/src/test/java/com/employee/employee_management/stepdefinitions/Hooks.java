package com.employee.employee_management.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.employee.employee_management.utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
