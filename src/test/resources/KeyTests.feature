Feature: Key Presses
  As a user
  I want to be able to enter text and perform key presses
  So that I can interact with the page and verify the results

  Scenario: Pressing BackSpace key
    Given I am on the Key Presses page
    When I enter the text "A" followed by the BACK_SPACE key
    Then I should see the result as "You entered: BACK_SPACE"