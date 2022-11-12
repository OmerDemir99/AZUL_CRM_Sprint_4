Feature: As a user, I should be able to create a  poll by clicking on Poll tab under Active Stream.

  Background: User logged in
    Given users should login with valid credentials as "hr"
    When user click the Poll button

  Scenario Outline: User should be able to add users by selecting multiple contacts from Employees and Department's contact lists
    And user click the Add more button
    And user click the Employees and departments button
    And user add "<users>" by selecting multiple contacts
    And user click Send button
    Then user should see the error message "The message title is not specified"

    Examples: add users by selecting multiple contacts from Employees and Department's contact lists
      | users                          |
      | hr88@cybertekschool.com        |
      | helpdesk28@cybertekschool.com  |
      | marketing85@cybertekschool.com |
      | helpdesk18@cybertekschool.com  |

  Scenario Outline: User should be able to add questions and multiple answers
    When user click the Add question button
    And user adds multiple questions "<question>" and multiple answers "<answer1>", "<answer2>"
    And user click Send button
    Then user should see the error message "Please specify at least one person."

    Examples:
      | question                  | answer1    | answer2   |
      | When is the event?        | on Monday, | on Friday |
      | Have polls been prepared? | yes,       | no        |
      | Where are the tasks?      |            |           |


  Scenario: User should be able to delete questions and multiple answers
    When user deletes questions and multiple answers


  Scenario: User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox
    When user click the Allow multiple choice button
    Then user should see the error message ""


  Scenario: User should be able to create a poll with mandatory fields
