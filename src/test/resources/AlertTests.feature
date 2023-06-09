Feature: JavaScript Alerts
  As a user
  I want to be able to handle JavaScript alerts
  So that I can interact with alert messages on the page

  Scenario: Accept Alert
    Given I am on the JavaScript Alerts page
    When I click on the "Click for JS Alert" button
    And I accept the alert
    Then I should see the result text as "You successfully clicked an alert"