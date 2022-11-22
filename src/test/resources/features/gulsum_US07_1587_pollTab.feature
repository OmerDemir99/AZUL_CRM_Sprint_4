Feature: As a user, I should be able to create a  poll by clicking on Poll tab under Active Stream.

  Background: User logged in
    Given users should login with valid credentials as "hr"


  Scenario Outline: User should be able to add users by selecting multiple contacts from Employees and Department's contact lists
    When user click the Poll button
    And user click the Add more button
    And user click the Employees and departments button
    Then user add "<users>" by selecting multiple contacts

    Examples: multiple users are added
      | users                          |
      | hr88@cybertekschool.com        |
      | helpdesk28@cybertekschool.com  |
      | marketing85@cybertekschool.com |
      | helpdesk18@cybertekschool.com  |

  Scenario: User should be able to add questions and multiple answers.
    When


