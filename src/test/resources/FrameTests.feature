Feature: Text Editor
  As a user
  I want to be able to edit text in a WYSIWYG editor
  So that I can format the text and perform editing actions

  Scenario: Editing text in the WYSIWYG editor
    Given I am on the WYSIWYG Editor page
    When I clear the text area in the editor
    And I set the text area to "TAU rocks!"
    Then I should see "TAU rocks!" as the text in the editor