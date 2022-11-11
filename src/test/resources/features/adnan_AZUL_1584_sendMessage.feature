Feature: As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  Background: User is already logged in.
    Given User goes to the login page
    Then User login to the application successfully
    When User clicks MESSAGE module


  Scenario: User should be able to send a message by filling in the mandatory fields.
    And User writes message into Message box
    Then User clicks SEND button


  Scenario:The message delivery should be to 'All employees' by default and should be changeable.
    Then All Employees button should be seen as default recipient
    And User should change the recipients


  Scenario: Verify that users CAN NOT send message without writing message body
    And User clicks SEND button
    Then "The message title is not specified" message should be displayed


  Scenario: Verify that users CAN NOT send message without adding a Recipient
    When User writes message into Message box
    And User removes default recipient
    And User clicks SEND button
    Then An "Please specify at least one person." message should be displayed


  Scenario: User should be able to CANCEL sending messages at any time before sending.
    When User writes message into Message box
    And User add some recipients for this message
    Then User cancels sending this message

  Scenario: User should be able to delete messages after sending.
    When User searches the message that he wants to delete
    Then User clicks the MORE button at the bottom of that message
    And  User clicks the Delete link
    And  User clicks the OK button on the pop up window
    And User sees "The post has been deleted." message on the window
