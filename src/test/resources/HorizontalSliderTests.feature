Feature: Slider
  As a user
  I want to be able to interact with a horizontal slider
  So that I can adjust the slider position and verify the range value

  Scenario: Adjusting the slider position
    Given I am on the Horizontal Slider page
    When I move the slider to the right by 6 units
    Then I should see the range value as "3"