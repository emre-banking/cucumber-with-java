Feature: Select Option
  As a user
  I want to be able to select an option from a dropdown
  So that I can choose a specific value

  Scenario: Selecting an option from the dropdown
    Given I am on the Dropdown page
    When I select "Option 1" from the dropdown
    Then I should see "Option 1" as the selected option