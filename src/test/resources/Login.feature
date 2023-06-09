Feature: Login functionality

  As a valid Para Bank customer
  I want to be able to login to the application
  So that I can access my account

  Scenario: Successful login

    Given I am on the login page of the Para Bank Application
    When I enter invalid credentials
    And click on the login button
    Then I should not be logged in successfully