Feature: Context Menu functionality
  As a user
  I want to be able to perform context clicking on the context menu page
  So that I can interact with the context menu options

  Scenario: Perform context click on the context menu
    Given I am on the home page
    When I click on the Context Menu link
    And I perform a context click action
    Then I should see a context menu alert with the message "You selected a context menu"
