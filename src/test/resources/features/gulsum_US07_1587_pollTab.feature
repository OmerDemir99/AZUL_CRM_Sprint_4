@smoke
Feature: As a user, I should be able to create a  poll by clicking on Poll tab under Active Stream.

  Background: User logged in
    Given users should login with valid credentials as "hr"
    When user click the Poll button


  Scenario: User should be able to add users by selecting multiple contacts from Employees and Department's contact lists
    When user click the "Add more" button
    And user click the Employees and departments button
    And user adds on usernames "user1" and "user2" and "user3"
    #And user adds "<users>" by selecting multiple contacts

    #Examples: add users by selecting multiple contacts from Employees and Department's contact lists
      #| users                          |
      #| helpdesk28@cybertekschool.com  |
      #| marketing85@cybertekschool.com |
      #| helpdesk18@cybertekschool.com  |
      #| marketing9@cybertekschool.com  |
      #| hr38@cybertekschool.com        |

  Scenario: User should be able to add questions and multiple answers
    When user adds question "question"
    And user adds answer "answer"
    And user adds second answer "answer"
    And user click the Add question button
    And user adds second question "question"
    And user adds second question's answer "answer"
    And user click the Add question button
    And user adds third question "question"
    And user adds third question's answer "answer"
    Then user adds third question's second answer "answer"

  Scenario: User should be able to delete questions and multiple answers
    And user adds question "question"
    And user deletes the question
    And user adds answer "answer"
    And user deletes the answer
    And user adds second answer "answer"
    And user deletes second answer
    And user click the Add question button
    And user adds second question "question"
    And user deletes second question
    And user adds second question's answer "answer"
    And user deletes second question's answer

  Scenario: User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox
    When user click the Allow multiple choice button
    And user click the Add question button
    Then user click the Allow multiple choice button under the second question


#Mandatory fields: Message title, recipient, 1 question, 2 answers -
#Error message: "The message title is not specified"
#Error message: "Please specify at least one person."
#Error message: "Please specify at least one question."
#Error message: "Please specify at least two answers.

  #AC5.1

  Scenario: User should be able to create a poll with mandatory fields
    When user click the "Add more" button
    And user click the Employees and departments button
    And user adds on usernames "user1" and "user2" and "user3"
    And user closes the opened users window
    And user adds question "question"
    And user adds answer "answer"
    And user adds second answer "answer"
    And user click Send button
    Then user should see title error message "The message title is not specified"

    #AC5.2
  @a
  Scenario: User should see "Please specify at least one person."
    When user writes message "message" in poll box
    And user removes All employees at To box
    And user adds question "question"
    And user adds answer "answer"
    And user adds second answer "answer"
    And user click Send button
    Then user should see person error message "Please specify at least one person."

    #AC5.3
  @a
  Scenario: User should see "Please specify at least one question."
    When user writes message "message" in poll box
    And user click the "Add more" button
    And user click the Employees and departments button
    And user adds on usernames "user1" and "user2" and "user3"
    And user closes the opened users window
    And user adds answer "answer"
    And user adds second answer "answer"
    And user click Send button
    Then user should see question error message "Please specify at least one question."

    #AC5.4
  @a
  Scenario: User should see "Please specify at least two answers."
    When user writes message "message" in poll box
    And user click the "Add more" button
    And user click the Employees and departments button
    And user adds on usernames "user1" and "user2" and "user3"
    And user closes the opened users window
    And user adds question "question"
    And user click Send button
    Then user should see answer error message "Please specify at least two answers."
