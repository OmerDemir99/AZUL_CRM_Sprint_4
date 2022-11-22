Feature: Functions on Company Structure under Employee menu

  AZUL-1585/US05: As a user, I should be able to use functions on Company Structure under Employee menu.


  Scenario: US05-AC-1 All user types should be able to display company structure
    Given users should login with valid credentials as "hr"
    When users click the employee button
    Then verify that users should be able to see company structure


  Scenario: US05-AC-1 All user types should be able to display company structure
    Given users should login with valid credentials as "helpdesk"
    When users click the employee button
    Then verify that users should be able to see company structure


  Scenario: US05-AC-1 All user types should be able to display company structure
    Given users should login with valid credentials as "marketing"
    When users click the employee button
    Then verify that users should be able to see company structure


  Scenario: US05-AC-2 Hr user should be able to add a department from the company structure
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users click the add button
    Then Verify that users should be able to see error message: "Section name is not specified."


  Scenario: US05-AC-2 Hr user should be able to add a department from the company structure
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And users click the add button
    Then verify that users see the department they just added


  Scenario: US05-AC-3 Hr user should be able to select a parent department from the department dropdown
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    Then verify that users should be able to select a parent department

  Scenario: US05-AC-4 Hr user should be able to select a supervisor from "recent"
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And verify that user see the select from structure article
    And users click the select from structure article
    And verify that users should be able to select recent
    Then users should be able to choose one of recent item


  Scenario: US05-AC-4 Hr user should be able to select a supervisor from  "company"
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And verify that user see the select from structure article
    And users click the select from structure article
    And verify that users should be able to select company
    Then users should be able to choose one of company item


  Scenario: US05-AC-4 Hr user should be able to select a supervisor from "search"
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And verify that user see the select from structure article
    And users click the select from structure article
    Then verify that users should be able to select search



  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    Then verify that users should be able to click the close button and pop-up closed



  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    Then verify that users should be able to click x button and pop-up closed


  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    Then verify that users should be able to click the close button and pop-up closed


  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    Then verify that users should be able to click x button and pop-up closed


  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    Then verify that users should be able to select a parent department
    Then verify that users should be able to click the close button and pop-up closed


  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    Then verify that users should be able to select a parent department
    Then verify that users should be able to click x button and pop-up closed



  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And verify that user see  and click the select from structure article
    And users choose the item from structure article
    Then verify that users should be able to click the close button and pop-up closed


  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And verify that user see the select from structure article
    And users click the select from structure article
    Then verify that users should be able to click x button and pop-up closed


  Scenario: US05-AC-6 Hr user should be able to edit departments after adding the department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And users click the add button
    And verify that users should be able to click the pencil mark on new department for editing

  Scenario: US05-AC-6 Hr user should be able to  add child departments after adding the department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And users click the add button
    ##
    And users click the plus mark on new department
    And users should be able to display new add department pop-up box
    And users write "Wooden Spoon" in department name input box
    And users click the add button
    And verify that user should be able to see child class


  Scenario: US05-AC-6 Hr user should be able to delete departments after adding the department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And users click the add button
    And users click the x mark on new department
    And users should be able to see warning message
    Then users click the ok button for delete the department


  Scenario: US05-AC-7 Hr user should be able to drag and drop the existing department under another department as a sub-department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And verify that users should be able to take a department box after that drag and drop it under another department


  Scenario: US05-AC-8 Helpdesk users can not change company structure.
    Given users should login with valid credentials as "helpdesk"
    When users click the employee button
    Then verify that users should be able to see company structure
    And verify that users should not see the add department button


  Scenario: US05-AC-8 Marketing users can not change company structure.
    Given users should login with valid credentials as "marketing"
    When users click the employee button
    Then verify that users should be able to see company structure
    And verify that users should not see the add department button







