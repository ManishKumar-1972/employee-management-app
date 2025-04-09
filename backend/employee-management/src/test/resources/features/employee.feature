Feature: Employee Management System

  Scenario: Add a new employee
    Given I open the employee management application
    When I enter "Bruce" in first name, "Wayne" in last name, and "bruce@wayne.com" in email
    And I click on the Add button
    Then I should see "Bruce" in the employee list

  Scenario: Try to submit empty form
    Given I open the employee management application
    When I click on the Add button without filling anything
    Then I should see an error toast

  Scenario: Delete an employee
    Given I open the employee management application
    When I delete the employee with email "bruce@wayne.com"
    Then I should not see "bruce@wayne.com" in the list
