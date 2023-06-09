Feature: Hover Functionality
  As a user
  I want to be able to hover over user figures
  So that I can see additional information and interact with the figure

  Scenario: Hovering over User 1
    Given I am on the Hovers page
    When I hover over the first user figure
    Then I should see the caption displayed
    And the caption title should be "name: user1"
    And the caption link text should be "View profile"
    And the caption link URL should end with "/users/1"