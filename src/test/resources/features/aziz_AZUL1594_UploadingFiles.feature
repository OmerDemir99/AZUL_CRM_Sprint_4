Feature: User should be able to upload files and pictures as messages

  Background: Login
    Given users should login with valid credentials as "hr"
    When user clicks the message button

  @wip
  Scenario:User should be able to upload multiple files at the same time.

    When User clicks the Upload files button
    And user clicks Upload files and images section
    And user selects three files from the database



  Scenario:User should be able to upload files in different formats.

    When User clicks the Upload files button
    And User sees Upload files and images section
    And user clicks Upload files and images section
    And user selects three files in different formats from the database
    And user clicks open button
    Then user sees three files in different formats are loaded to the message panel


    Scenario: User should be able to upload pictures.

    When User clicks the Upload files button
    And User sees Upload files and images section
    And user clicks Upload files and images section
    And user selects a picture from the database
    And user clicks open button
    Then user sees picture is loaded to the message panel