Feature: Functions on Company Structure under Employee menu

  AZUL-1585/US05: As a user, I should be able to use functions on Company Structure under Employee menu.

  @AZUL-1626
  Scenario: US05-AC-1 All user types should be able to display company structure
    Given users should login with valid credentials as "hr"
    When users click the employee button
    Then verify that users should be able to see company structure

  @AZUL-1627
  Scenario: US05-AC-1 All user types should be able to display company structure
    Given users should login with valid credentials as "helpdesk"
    When users click the employee button
    Then verify that users should be able to see company structure

  @AZUL-1628
  Scenario: US05-AC-1 All user types should be able to display company structure
    Given users should login with valid credentials as "marketing"
    When users click the employee button
    Then verify that users should be able to see company structure

  @AZUL-1629
  Scenario: US05-AC-2 Hr user should be able to add a department from the company structure
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users click the add button
    Then Verify that users should be able to see error message: "Section name is not specified."

  @AZUL-1630
  Scenario: US05-AC-2 Hr user should be able to add a department from the company structure
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And users click the add button
    Then verify that users see the department they just added
    Then users delete this departments


  @AZUL-1631
  Scenario: US05-AC-3 Hr user should be able to select a parent department from the department dropdown
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    Then verify that users should be able to select a parent department

  @AZUL-1632
  Scenario: US05-AC-4 Hr user should be able to select a supervisor from "recent"
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And verify that user see the select from structure article
    And users click the select from structure article
    And verify that users should be able to select recent
    Then users should be able to choose one of recent item

  @AZUL-1633
  Scenario: US05-AC-4 Hr user should be able to select a supervisor from  "company"
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And verify that user see the select from structure article
    And users click the select from structure article
    And verify that users should be able to select company
    Then users should be able to choose one of company item

  @AZUL-1634
  Scenario: US05-AC-4 Hr user should be able to select a supervisor from "search"
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And verify that user see the select from structure article
    And users click the select from structure article
    Then verify that users should be able to select search

  @AZUL-1711
  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    Then verify that users should be able to click the close button and pop-up closed

  @AZUL-1712
  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    Then verify that users should be able to click x button and pop-up closed

  @AZUL-1713
  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    Then verify that users should be able to click the close button and pop-up closed

  @AZUL-1714
  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    Then verify that users should be able to click x button and pop-up closed

  @AZUL-1715
  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    Then verify that users should be able to select a parent department
    Then verify that users should be able to click the close button and pop-up closed

  @AZUL-1716
  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    Then verify that users should be able to select a parent department
    Then verify that users should be able to click x button and pop-up closed

  @AZUL-1717
  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And verify that user see  and click the select from structure article
    And users choose the item from structure article
    Then verify that users should be able to click the close button and pop-up closed

  @AZUL-1718
  Scenario: US05-AC-5 Hr user should be able to close add department pop-up at any time before sending
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And verify that user see the select from structure article
    And users click the select from structure article
    Then verify that users should be able to click x button and pop-up closed

  @AZUL-1719
  Scenario: US05-AC-6 Hr user should be able to edit departments after adding the department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And users click the add button
    And verify that users should be able to click the pencil mark on new department for editing
    Then users delete this departments


  @AZUL-1720
  Scenario: US05-AC-6 Hr user should be able to  add child departments after adding the department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And users click the add button

  @AZUL-1721
  Scenario: US05-AC-6 Hr user should be able to  add child departments after adding the department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the plus mark on new department
    And users should be able to display new add department pop-up box
    And users write "Wooden Spoon" in department name input box
    And users click the add button
    And verify that user should be able to see child class

  @AZUL-1722
  Scenario: US05-AC-6 Hr user should be able to delete departments after adding the department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the add department button
    And users write "Catch The Bug" in department name input box
    And users click the add button


  @AZUL-1723
  Scenario: US05-AC-6 Hr user should be able to delete departments after adding the department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And users click the x mark on new department
    And users should be able to see warning message

  @AZUL-1724 @smoke
  Scenario: US05-AC-7 Hr user should be able to drag and drop the existing department under another department as a sub-department
    Given users should login with valid credentials as "hr"
    When users click the employee button
    And verify that users should be able to take a department box after that drag and drop it under another department

  @AZUL-1725
  Scenario: US05-AC-8 Helpdesk users can not change company structure.
    Given users should login with valid credentials as "helpdesk"
    When users click the employee button
    Then verify that users should be able to see company structure
    And verify that users should not see the add department button

  @AZUL-1726
  Scenario: US05-AC-8 Marketing users can not change company structure.
    Given users should login with valid credentials as "marketing"
    When users click the employee button
    Then verify that users should be able to see company structure
    And verify that users should not see the add department button









